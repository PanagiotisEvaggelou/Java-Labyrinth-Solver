

/**
 * ListNode represents a list node
 * Each node contains an int as data and a reference to the next node in the list.
 */
public class Node3 {
    protected String item;
    protected Node3 next = null;

    /**
     * Constructor. Sets data
     *
     * @param data the data stored
     * @return
     */
    Node3(String item) {
        this.item = item;
    }

    /**
     * Returns this node's data
     *
     * @return the reference to node's data
     */
    public String getData() {
        // return data stored in this node
        return item;
    }

    /**
     * Get reference to next node
     *
     * @return the next node
     */
    public Node3 getNext() {
        // get next node
        return next;
    }


    /**
     * Set reference to next node
     *
     * @param next reference
     */
    public void setNext(Node3 next) {
        this.next = next;
    }
}