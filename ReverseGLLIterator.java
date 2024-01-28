import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseGLLIterator<T> implements Iterator<T> {
    GenericList<T>.Node<T> head;
    private GenericList<T>.Node<T> current; // this stores the tail of the linked list
    ReverseGLLIterator(GenericList<T>.Node<T> head) {
        this.head = head;

        // storing the last node in 'current'
        current = head;

        while(current.next!=null) {
            current = current.next;
        }
    }

    @Override
    public boolean hasNext() {

        // I THINK THIS LINE IS WRONG, SO COMMENTED IT OUT
        GenericList<T>.Node<T> current = head;
        return (current!=null) ;
    }

    @Override
    public T next() {
        // Check if current is null, if yes, throw NoSuchElementException
        if (current == null) {
            throw new NoSuchElementException();
        }

        // Retrieve and store the value to be returned
        T data = current.data;

        // Move to the previous node
        GenericList<T>.Node<T> temp = head;
        GenericList<T>.Node<T> prev = null;

        while (temp != current) {
            prev = temp;
            temp = temp.next;
        }

        // Update current to the previous node
        current = prev;

        // Return the value
        return data;
    }

}