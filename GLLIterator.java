import java.util.Iterator;
import java.util.NoSuchElementException;

public class GLLIterator<T> implements Iterator<T> {
    GenericList<T>.Node<T> head;

    // defining constructor of GLLIterator
    // set current to head
    GLLIterator(GenericList<T>.Node<T> head) {

        this.head = head;
    }

    // This function returns true/false depending on whether the queue has another element to
    // iterate over
    @Override
    public boolean hasNext() {

        GenericList<T>.Node<T> current = head;

        return (current!=null);
    }

    @Override
    public T next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        GenericList<T>.Node<T> current = head;
        T data = current.data;
        head = head.next;

        return data;
    }
}
