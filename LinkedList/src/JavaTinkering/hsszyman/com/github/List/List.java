package JavaTinkering.hsszyman.com.github.List;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Simple implementation of a list
 * @param <T> : The data type that the list will store
 */
public class List<T> implements java.util.List<T> {

    // Keep a reference to the first node in the list
    private Node<T> first = null;

    // Init list with a single value
    public List (T value) {
        first = new Node<>(value);
    }

    // Init list with multiple values
    public List (T... values) {
        if (values.length > 0)
            first = new Node<>(values[0]);
        addRest(first, values, 1);
    }

    // Init list as an empty list
    public List () {}


    /**
     * add set of values to possiblan existing linked list
     * @param values : values to add
     */
    public void addSet(T... values) {
        if (first != null)
            addRest(getLastNode(first), values, 0);
        else {
            first = new Node<>(values[0]);
            addRest(getLastNode(first), values, 1);
        }
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return null;
    }

    /**
     * Add a value to the end of the linked list
     * @param value : value to be added at the end of list
     */
    @Override
    public boolean add(T value) {
        if (first != null) getLastNode(first).setNext(new Node<>(value));
        else first = new Node<>(value);
    }


    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public java.util.List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void addNode(Node<T> newNode) {
        if (first!=null) getLastNode(first).setNext(newNode);
        else first = newNode;
    }


    @Override
    public boolean remove(Object target) throws ClassCastException{

        Node<T> tmpNode = find((T) target, first); // not really sure how else to d oit
        boolean exists = false;
        if (first.getVal().equals(target)) {
            exists = true;
            first = first.getNext();
        }
        else if (tmpNode != null) {
            tmpNode.setNext(tmpNode.getNext().getNext());
            return true;
        }
        return exists;
    }

    public void printAll() {
        printAll(first);
    }

    /**
     * Given a list, add the first element of that list to the next of
     * @param list
     */
    public void linkList(List<T> list) {
        Node<T> lastNode = this.getLastNode(this.first);
        lastNode.setNext(list.first);
    }

    /**
     * @param list
     */
    public void concatList(List<T> list) {
        this.addNode(this.buildList(list.first));
    }

    /**
     * Create a series of linked nodes that is added to the end of the list
     * extending it.
     * @param current
     * @return
     */
    private Node<T> buildList(Node<T> current) {
        if (current != null) {
            Node<T> tmpNode = new Node<>(current.getVal());
            tmpNode.setNext(buildList(current.getNext()));
            return tmpNode;
        }
        else {
            return current;
        }
    }

    public T getFirst() {
        return first.getVal();
    }

    /**
     * @return last value in the list
     */
    public T getLast() {
        return getLastNode(first).getVal();
    }

    /**
     * Given an existing node, a list of values and an index
     * of where to select the next value from the array,
     * populate
     * the list with the values in the array recursively
     * NOTE: This is used internally and ideally, only once in the
     * multi-value constructor
     * @param current
     * @param values
     * @param currentArrIndex
     */
    private void addRest(Node<T> current, T[] values, int currentArrIndex) {
        if (current != null && currentArrIndex < values.length) {
            current.next = new Node<>(values[currentArrIndex]);
            ++currentArrIndex;
            addRest(current.next, values, currentArrIndex);
        }
    }

    private void printAll(Node<T> current) {
        System.out.println(current.getVal().toString());
        if (current.hasNext()) {
            printAll(current.getNext());
        }
    }


    /**
     * PRECONDITION : Node is non-null
     * For a given node depending on if the next is null either recurse with the next node or return current
     * (If current.getNext is null, we know it's at the end of the list)
     * @param current : current node to check
     * @return last node in the linked list
     */
    private Node<T> getLastNode(Node<T> current) {
        return (current.getNext() != null) ? (getLastNode(current.getNext())) : (current);
    }

    // Returns pointer one before the one found
    private Node<T> find(T val, Node<T> current) {
        if (current.hasNext()) {
            return current.getNext().getVal().equals(val) ? current : find(val, current.getNext());
        }
        else {
            return null;
        }
    }

    private class Node<T> {
        private T val;
        private Node<T> next;
        private Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }

        Node() {
            this(null, null);
        }

        Node(T val) {
            this(val, null);
        }

        T getVal() {
            return val;
        }

        void setVal(T val) {
            this.val = val;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }

        boolean hasNext() {
            return next != null;
        }
    }
}
