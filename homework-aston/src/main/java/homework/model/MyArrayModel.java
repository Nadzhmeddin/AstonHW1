package homework.model;

import homework.exceptions.CapacityException;
import homework.exceptions.IndexGreaterSizeException;
import homework.exceptions.IndexLessZeroException;
import homework.exceptions.IndexOutSizeException;
import homework.impl.ArrayMethods;

import java.util.NoSuchElementException;

/**
 * Creating my own ArrayList implementation implements all methods from interface ArrayMethods
 * @param <E>
 */
public class MyArrayModel<E> implements ArrayMethods<E>{

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    protected Object[] elementList;


    /**
     * An empty MyArrayModel constructor where the minimum capacity size is 10.
     */
    public MyArrayModel() {
        this.capacity = DEFAULT_CAPACITY;
        this.elementList = new Object[capacity];
    }


    /**
     * MyArrayModel constructor, in which the size of the array capacity is immediately set.
     * @param capacity array capacity
     * @CapacityException handling negative capacitance transfer
     */
    public MyArrayModel(int capacity) {
        try {
            this.capacity = capacity;
            if(capacity < 0) throw new CapacityException("Некорректный размер: " + capacity);
            if(capacity < DEFAULT_CAPACITY & capacity > 0) elementList = new Object[DEFAULT_CAPACITY];
            else elementList = new Object[capacity];
        } catch (CapacityException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method to get array capacity
     * @return current capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method to get array size
     * @return current size
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to get array element
     * @return element from array
     */
    public Object[] getElementList() {
        return  elementList;
    }

    @Override
    public int size() {
        return getSize();
    }

    /**
     * Method of adding to an array, where only the object to be added is indicated.
     * Note: In this method, the object is added to the end of the array automatically.
     * @param element the object to add to the array
     */
    @Override
    public boolean add(E element) {
        if(size() >= capacity) {
            newMoreCapacity();
        }
        elementList[size++] = element;
        return true;
    }

    /**
     * Method for increasing array capacity when full
     */
    public void newMoreCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] newElementList = new Object[capacity];
        for(int i = 0; i < size(); i++) {
            newElementList[i] = elementList[i];
            elementList[i] = null;
        }
        elementList = newElementList;
    }


    /**
     * Overridden add method, where the position in the index array and the element object are specified
     * @param index position in the array
     * @param element the object to insert
     */
    @Override
    public void add(int index, E element) {
        try {
            if(index < 0)
                throw new IndexLessZeroException("Index must be greater or equal to zero.\nYour index: " + index);
            if(index > size())
                throw new IndexGreaterSizeException(index, size());
            if(size() + 1 >= capacity) {
                newMoreCapacity();
            }
            for(int i = size(); i > index; i--) {
                elementList[i + 1] = elementList[i];
            }
            elementList[index] = element;
            size++;
        } catch (IndexLessZeroException | IndexGreaterSizeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for removing an element from an array at a specified index
     * @param index index received from the user
     * @return element
     */
    @Override
    public E remove(int index) {
        try{
            if(index > size() || index < 0) {
                throw new IndexGreaterSizeException(index, size());
            }
        } catch (IndexGreaterSizeException e) {
            e.printStackTrace();
        }
        E arrayElement = (E) elementList[index];
        if(index < size()) {
            elementList[index] = null;
            createNewArray((E[]) elementList);
        }
        return arrayElement;
    }

    /**
     * Method for removing an element from an array based on a specified user element
     * @param element The specified element received from the user
     */
    @Override
    public void remove(E element) {
        boolean isFound = false;
        for(int i = 0; i < size(); i++) {
            if(elementList[i].equals(element)) {
                isFound = true;
                elementList[i] = null;
                break;
            }
        }
        if(!isFound) {
            throw new NoSuchElementException("This element does not exist.");
        }
    }


    /**
     * Method for creating a new array and copying the old one into it
     * @param elementList old array from which elements are copied
     */
    private void createNewArray(E[] elementList) {
        E[] newElementList = (E[]) new Object[elementList.length];
        int j = 0;
        for(int i = 0; i < elementList.length; i++) {
            newElementList[j] = (elementList[i] != null) ? elementList[i] : elementList[++i];
            j++;
            if(elementList[i] == null && i + 1 < capacity && elementList[i + 1] == null)
                break;
        }
        this.elementList = newElementList;
    }

    /**
     * Method for getting an element at a specified position
     * @param index position
     * @return returns the element at the specified position
     */
    @Override
    public E get(int index) {
        try{
            if(index < 0) throw new IndexLessZeroException("Index must be greater or equal to zero.\nYour index: " + index);
            if(index >= size()) throw new IndexOutSizeException("Index must be less or equal to size.\nYour index: "+ size());
        } catch (IndexLessZeroException | IndexOutSizeException e) {
            e.printStackTrace();
        }
        return (E) elementList[index];
    }


    /**
     * A method for completely clearing an array where the size is also equals zero
     */
    @Override
    public void clear() {
        for(int i = 0; i < size(); i++) {
            elementList[i] = null;
        }
        size = 0;
    }

    /**
     * Method for changing an element from the current array by index and indicating a new element
     * @param index position of the element being changed in the array
     * @param element the value of the new element to insert into the array
     */
    @Override
    public E set(int index, Object element) {
        if(index < size() && index >= 0) {
            Object oldElement = elementList[index];
            elementList[index] = element;
            return (E) oldElement;
        }
        return null;
    }

    /**
     * A method for outputting an array to the console, where all elements with the attribute null are ignored
     */
    @Override
    public void printArray() {
        System.out.print("[ ");
        for (Object element : elementList) {
            if(element != null) {
                System.out.print(element + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
