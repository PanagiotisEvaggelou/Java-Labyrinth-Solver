
import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Single-link List. Uses {@link Node} for list nodes.
 */
class Stack<T> implements StackInter<T> {

    private Node2<T> top = null;
    private Node2<T> base = null;
    private int s = 0;

    /**
     * Default constructor
     */
    public Stack() {
    }

    /**
     * Determine whether list is empty
     *
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Inserts the data at the top of the list
     *
     * @param data the inserted data
     */
    @Override
    public void push(T item) {
        Node2<T> n = new Node2<>(item);
        s++;

        if (isEmpty()) {
            base = n;
            top = n;
        } else {
            top.setNext(n);
            top = n;
        }
    }


    /**
     * Returns and removes the data from the list tail
     *
     * @return the data contained in the list tail
     * @throws EmptyListException if the list is empty
     */
    @Override
    public T pop() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T item = top.getData();
        s--;

        if (base == top)
           base = top = null;
        else {
            Node2<T> iterator = base;
            while (iterator.getNext() != top)
                iterator = iterator.getNext();

            iterator.setNext(null);
            top = iterator;
        }

        return item;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();

        T item = top.getData();

        return item;
    }

    public int size() {
        return s;
    }

    public void printStack(PrintStream stream) {
        Node2<T> node = base;

        while (node!=null){
            stream.println(node.getData());
            stream.flush();
            node = node.next;
        }
    }


}
