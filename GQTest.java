import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class GQTest {

    // GenericQueueConstructorTest tests the constructor
    @Test
    public void ConstructorTest() {
        GenericQueue<Integer> queue = new GenericQueue<>(67);
        assertEquals(67, queue.getHead().data);
        assertEquals(1, queue.getLength());
    }

    @Test
    public void TestAddFunction() {
        GenericQueue<Integer> queue = new GenericQueue<>(19);

        queue.add(26);
        queue.add(34);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(19);
        expected.add(26);
        expected.add(34);

        //assertEquals(expected, queue.dumpList());
    }

    @Test
    public void TestAddWithCode() {
        GenericQueue<Integer> queue = new GenericQueue<>(1);

        queue.add(2, 42);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);

        //assertEquals(expected, queue.dumpList());
    }

    @Test
    public void TestDeleteFunction() {
        GenericQueue<Integer> queue = new GenericQueue<>(19);

        queue.add(26);
        queue.add(34);

        int deletedValue = queue.delete();

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(26);
        expected.add(34);

        // assertEquals(expected, queue.dumpList());
        assertEquals(19, deletedValue);
    }

    @Test
    public void TestEnqueueAndDequeueFunctions() {
        GenericQueue<Integer> queue = new GenericQueue<>(19);

        queue.enqueue(26);
        queue.enqueue(34);

        int dequeuedValue = queue.dequeue();

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(26);
        expected.add(34);
        assertEquals(2, queue.getLength());
        assertEquals(19, dequeuedValue);
    }

    @Test
    public void TestHasNextNonEmptyList() {
        GenericQueue<Integer> list = new GenericQueue<>(null);
        list.add(19);
        GLLIterator<Integer> iterator = new GLLIterator<>(list.getHead());

        assertTrue(iterator.hasNext());
    }

    @Test
    public void TestNextNonEmptyList() {
        GenericQueue<Integer> list = new GenericQueue<>(1);
        list.add(1);
        list.add(2);
        list.add(3);

        GLLIterator<Integer> iterator = new GLLIterator<>(list.getHead());

        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
    }


    @Test
    public void HasNextWithNonEmptyList() {
        GenericList<Integer> list = new GenericQueue<>(1);
        list.add(1);
        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(list.getHead());

        assertTrue(iterator.hasNext());
    }

    @Test
    public void NextWithNonEmptyList() {
        GenericList<Integer> list = new GenericQueue<>(4);
        list.add(1);
        list.add(2);
        list.add(3);
        ReverseGLLIterator<Integer> iterator = new ReverseGLLIterator<>(list.getHead());

        assertTrue(iterator.hasNext());

        assertEquals(Integer.valueOf(3), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(4), iterator.next());
    }
}
