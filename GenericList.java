import java.util.ArrayList;
import java.util.Iterator;

// The iterable will allow clients of my LL to use a forEach loop to iterate.
public abstract class GenericList<T> implements Iterable<T>{

    public class Node<T> {
        T data; // contains the data being stored in the list
        int code; // optional field
        Node<T> next; // reference to the next node in the list

        // default constructor for Node<T> class
        Node() {
            data = null;
            next = null;
            code = 0;
        }
    }
    private Node<T> head;
    private int length;

    // default constructor for GenericList class
    public GenericList() {
        head = new Node<T>();
        length = 0;
    }

    // defining getters and setters for the private data members
    public int getLength() {
        return this.length;
    }

    public void setLength(int new_length) {
        length = new_length;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> new_head) {
        head = new_head;
    }

    // This function prints items of the list, one value per line
    // If list is empty, print "Empty List"
    public void print() {
        if (head == null) {
            System.out.println("Empty List");
        }

        Node<T> current = head; // stores the current node of the linked list
        while (current.next != null) {
            System.out.println(current.data);
        }
        System.out.println();
    }

    // declaring the abstract add function
    public abstract void add (T data);
    // defining the abstract delete function - deletes from the front, back, etc.
    public abstract T delete();

    // This function stores all values present currently in the list
    // into an ArrayList and returns it
    public ArrayList<T> dumpList() {
        ArrayList<T> elements = new ArrayList<T>();

        Node<T> current = head; // current stores the current node of the linkedlist
        while (current.next != null) {
            elements.add(current.data);
           // length++; // concurrently calculating the length of the ArrayList
            current = current.next;
        }
        return elements;
    }

    // This function returns the value at the specified index or null
    // if the index is out of bounds
    public T get(int index) {

        if (index<0 || index>=getLength()) {
            return null;
        }

        Node<T> current = head;

        for (int i=0; i<=index; ++i) {
            current = current.next;
        }
        return current.data;
    }

    // This function replaces the element at specified position in the list
    // with the specified element and return the element previously at the specified position.
    // return null if index is out of bounds
    public T set(int index, T element) {
        if (index>=getLength() || index<0) {
            return null;
        }

        T previous = get(index);

        Node<T> current = head;
        for(int i=0; i<=index; ++i) {
            current = current.next;
        }

        current.data = element;

        return previous;
    }

    // returns an iterator over the elements of the list in reverse order( tail to head)

    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(head);
    }

}
