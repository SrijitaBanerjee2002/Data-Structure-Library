import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HMIterator<T> implements Iterator<T> {
    private ArrayList<GenericQueue<T>> buckets;
    private int currentBucketIndex;
    private Iterator<T> currentBucketIterator;

    public HMIterator(ArrayList<GenericQueue<T>> buckets) {
        this.buckets = buckets;
        this.currentBucketIndex = 0;
        this.currentBucketIterator = null;
    }

    @Override
    public boolean hasNext() {
        // If the current bucket iterator has more elements, return true
        if (currentBucketIterator != null && currentBucketIterator.hasNext()) {
            return true;
        }

        // Look for the next non-empty bucket with elements
        while (currentBucketIndex < buckets.size()) {
            GenericQueue<T> currentBucket = buckets.get(currentBucketIndex);
            if (currentBucket != null) {
                currentBucketIterator = currentBucket.iterator();
                return currentBucketIterator.hasNext();
            }
            currentBucketIndex++;
        }

        return false; // No more elements in any bucket
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the map");
        }

        return currentBucketIterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}

