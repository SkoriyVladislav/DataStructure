package by.epam.tr;

import java.util.*;

public interface MyList<T> {

    int size();

    boolean isEmpty();

    boolean contains(T o);

    T[] toArray();

    boolean add(T o);

    boolean remove(T o);

    boolean addAll(Collection<? extends T> c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    T get(int index);

    T set(int index, T element);

    void add(int index, T element);

    Object remove(int index);

    int indexOf(T o);
}
