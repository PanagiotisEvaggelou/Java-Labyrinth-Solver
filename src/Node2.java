

/**
 * ListNode represents a list node
 * Each node contains an int as data and a reference to the next node in the list.
 */
public class Node2<T> {
    protected T item;
    protected Node2 next = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    Node2(T item) {
        this.item = item;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public T getData() {
        // return data stored in this node
        return item;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public Node2<T> getNext() {
        // get next node
        return next;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(Node2<T> next) {
        this.next = next;
    }
}
