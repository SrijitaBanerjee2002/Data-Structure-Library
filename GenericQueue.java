import org.w3c.dom.Node;

import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T>{

    Node<T> tail; // traditional reference to the tail of the list

    // defining a default constructor
    GenericQueue() {
        setHead(null);
        setLength(0);
        tail = null;
    }

    // parameterized constructor #1
    // initialise head, tail and length
    GenericQueue(T data) {
        Node<T> some_node = new Node<T>();

        some_node.data = data; // setting the data for the node with the parameterized input

        setHead(some_node); // setting the head node of the linked list

        // some_node is the first node of the linked list
        // so, both head and tail pointers point to the first node
        tail = some_node; // setting the tail node of the linked list
        setLength(1); // only 1 element added to the linked list
    }


    @Override
    // This function appends a new element to the end of the linked list
    public void add(T data) {
        Node<T> head = getHead(); // points to the first node of the linked list
        Node<T> current = head; // stores the current node in the linked list
        Node<T> tail = head; // points to the last node in the linked list

        // creating a new node of the linked list
        Node<T> new_node = new Node<T>();
        new_node.data = data;

        // checking if the list is empty
        // if so, head = tail = new_node
        if (head == null) {
            head = new_node;
            tail = new_node;
        }

        // making tail point to the last node of the linked list
        while (tail.next!=null) {
            tail = tail.next;
        }

        tail.next = new_node; // appended the new node at the end of the list
        tail = new_node;

        // calculating length of the linked list
        int len = 0;
        while (current.next!=null) {
            len++;
            current = current.next;
        }

        // setting the length of the list
        setLength(len);
    }

    // deleting the head of the linked list (queue follows a FIFO method)
    @Override
    public T delete() {
        // checking if the list is empty
        // if so, return null
        Node<T> head = getHead();

        if (head == null) {
            return null;
        }

        T value = head.data;

        head = head.next;


        return value; // this function returns the value of the node stored in the head pointer
    }

    // overloaded method add()
    // this function also sets the code data member to the value passed in
    public void add(T data, int code) {
        Node<T> head = getHead();

        // creating the new node
        Node<T> new_node = new Node<T>();
        new_node.data = data;
        new_node.code = code;

        if (head==null) {
            head = new_node;
            tail = new_node;
        }
        // making tail point to the last node of the linked list
        while (tail.next!=null) {
            tail = tail.next;
        }

        tail.next = new_node; // appended the new node at the end of the list

        // calculating length of the linked list
        int len = 0;
        Node<T> current = head;
        while (current.next!=null) {
            len++;
            current = current.next;
        }

        // setting the length of the list
        setLength(len);
    }

    // implementing enqueue function
    // simply calling the add() function
    public void enqueue (T data) {

        // calling the add() function
        add(data);
    }

    // implementing the dequeue function
    // simply calling the delete() function
    public T dequeue() {
        return delete();
    }


    @Override
    public Iterator<T> iterator() {
        return new GLLIterator<T>(this.getHead());
    }
}
