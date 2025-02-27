import java.util.Arrays;

/**
 * A class that implements a stack using an array as the underlying data structure. A stack is a data structure that
 * follows the Last In First Out (LIFO) principle. This means that the last element added to the stack is the first one
 * to be removed.
 *
 * @param <E> the type of elements that the stack will hold
 */
public class ArrayStack<E>
{
    private E[] list;
    private int size;
    private int capacity;

    /**
     * Default constructor that initializes the stack with a capacity of 10.
     *
     * @pre none
     *
     * @post list = new Object[10] AND size = 0 AND capacity = 10
     */
    public ArrayStack() {
        this.capacity = 10;
        this.list = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Parameterized constructor that initializes the stack with a specified capacity.
     *
     * @param capacity the initial capacity of the stack
     *
     * @pre capacity > 0
     *
     * @post list = new Object[capacity] AND size = 0 AND capacity = #capacity
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.list = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Pushes an element onto the top of the stack. This method is effectively a mutator.
     *
     * @param element the element to be pushed onto the stack
     *
     * @pre element != null
     *
     * @post list[size] = element AND size = size + 1 AND capacity = #capacity
     */
    public void push(E element) {
        list[size++] = element;
    }

    /**
     * Removes and returns the element at the top of the stack. This method is effectively a mutator.
     *
     * @return the element at the top of the stack
     *
     * @pre size > 0
     *
     * @post pop = the item at the front of the stack AND list = #list with the element at the front of the stack
     * removed AND size = size - 1 AND capacity = #capacity
     */
    public E pop() {
        E element = list[--size];
        list[size] = null; // Avoid memory leak
        return element;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     *
     * @pre size > 0
     *
     * @post peek = The item at the front of the stack AND list = #list AND size = #size AND capacity = #capacity
     */
    public E peek() {
        return list[size - 1];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     *
     * @pre none
     *
     * @post isEmpty = (size == 0) AND list = #list AND size = #size AND capacity = #capacity
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears all elements from the stack. This method is effectively a mutator.
     *
     * @pre none
     *
     * @post list = new Object[capacity] AND size = 0 AND capacity = #capacity
     */
    public void clear() {
        Arrays.fill(list, 0, size, null);
        size = 0;
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     *
     * @pre none
     *
     * @post toString = "[" + list[0] + ", " + list[1] + ", ..., list[size - 1] + "]" AND list = #list AND size = #size
     * AND capacity = #capacity
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}