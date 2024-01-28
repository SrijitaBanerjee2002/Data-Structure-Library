import java.util.Iterator;
import java.util.ArrayList;
public class MyHashMap<T> implements Iterable<T> {

    // declaring data members
    ArrayList<GenericQueue<T>> map;
    private int length;

    MyHashMap(String key, T value) {
        map = new ArrayList<GenericQueue<T>>(10);
        length = 0;

        // Initializing the map with empty GenericQueue objects
        for (int i = 0; i < 10; i++) {
            map.add((null));
        }

        // adding the 1st key/value pair into the ArrayList
        // using put(String,T) method
        put(key,value);
    }

    public void put(String key, T value) {
        int hash_code = key.hashCode(); // getting the hash code
        int index = hash_code&9; // getting index in the ArrayList

        // adding a new node with the data and code to the arraylist at the part
            GenericQueue<T> gq = new GenericQueue<T>(value);
            //gq.add(value);
            gq.add(value,hash_code); // adding the node
            map.add(index,gq); // setting it on the map
            length++;
    }

    // This function returns true if a certain key exists in the hashmap
    public boolean contains(String key) {
        // getting the code to compare with, in the queue
        int code = key.hashCode();

        // storing the queue at the index
        int index = code&9;

        // queue contains the LinkedList of nodes at the particular index
        GenericQueue<T> queue = map.get(index);

        // 'current' stores the head node of the 'queue'
        GenericList<T>.Node<T> current = queue.getHead();

        while(current.next!=null) {
            if(current.code == code) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // This function returns the value at the given key, or return null
    public T get(String key) {
        int code_of_key = key.hashCode();

        int index = code_of_key&9;


        // 'queue' contains the LinkedList of nodes at the particular index
        GenericQueue<T> queue = map.get(index);

        GenericList<T>.Node<T> head = queue.getHead();
        GenericList<T>.Node<T> current = head; // for keeping track of the current element

        // if there is only 1 element in the queue,
        // return the data stored in the head node

        System.out.println(current.next.data);

        // traversing through the 'queue'
        while(current.next!=null) {
            if(current.code == code_of_key) {
                return current.data; // returning the value at the given key
            }
            current = current.next;
        }
        return null;
    }

    // This function returns the total number of nodes in the hashmap
    public int size() {
        /*
        int ctr = 0;
        for(int i=0; i<map.size(); ++i) {
            GenericQueue<T> queue = map.get(i); // getting each 'queue' in the arraylist
            if(queue != null) {
                ctr += queue.getLength();
            }
        }
        return ctr;
        */
        return length;
    }

    // This function returns true if the map has contains no key-value mappings at all
    public boolean isEmpty() {
        for (int i=0; i<map.size(); ++i) {
            GenericQueue<T> queue = map.get(i);

            // if queue is NOT null, the map is NOT empty
            // immediately return false
            return false;
        }
        return true;
    }

    //This function replaces the entry for the specified key only
    // if it is correctly mapped to some value
    public T replace(String key, T value) {
        int code = key.hashCode();
        int index = code&9;

        GenericQueue<T> queue = map.get(index); // getting the LinkedList at the index

        // current will iterate over the queue
        GenericList<T>.Node<T> current = queue.getHead();

        while(current!=null) {
            if(current.code == code) {
                T data = current.data;
                current.data = value;
                return data;
            }
            current = current.next;
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
