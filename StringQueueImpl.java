
import java.io.PrintStream;
import java.util.NoSuchElementException;

import edu.aueb.ds.exceptions.EmptyListException;

/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
class StringQueueImpl implements StringQueue {

    private Node3 front = null;
    private Node3 back = null;
    private int s = 0;

    /**
     * Default constructor
     */
    public StringQueueImpl() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Inserts the data at the front of the list
     *
     * @param data the inserted data
     */
    @Override
    public void put(String item) {
        Node3 n = new Node3(item);
        s++;

        if (isEmpty()) {
            front = n;
            back = n;
        } else {
            back.setNext(n);
            back = n;
        }
    }


    /**
     * Returns and removes the data from the list head
     *
     * @return the data contained in the list head
     * @throws EmptyListException if the list is empty
     */
    @Override
    public String get() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        String item = front.getData();
        s--;

        if (front == back)
            front = back = null;
        else
            front = front.getNext();

        return item;
    }

    @Override
    public String peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        String item = front.getData();

        return item;
    }

    public int size() {
        return s;
    }

    public void printQueue(PrintStream stream){
        Node3 node = front;

        while (node!=null){
            stream.println(node.getData());
            stream.flush();
            node = node.next;
        }
    }
}