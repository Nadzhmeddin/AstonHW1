package homework.impl;

/**
 * Interface with array methods
 * @param <E> generic
 */
public interface ArrayMethods<E> {

    boolean add(E element);
    void add(int index, E element);
    E remove(int index);
    void remove(E element);
    E get(int index);
    void clear();
    E set(int index, E element);
    void printArray();
    int size();

}
