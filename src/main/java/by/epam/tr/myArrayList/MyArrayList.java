package by.epam.tr.myArrayList;
import by.epam.tr.myList;

import java.util.*;

public class MyArrayList<T> implements myList<T>, Iterable<T> {
    private Object[] array;
    private int size;

    public <T> MyArrayList() {
        array = new Object[size];
        size = 0;
    }

    public <T> MyArrayList(int length) {
        array = new Object[size];
        size = length;
    }

    public <T> MyArrayList(MyArrayList<T> newArrayList) {
        array = newArrayList.array;
        size = newArrayList.size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean contains(T o) {
        for (Object element : array) {
            if (element != null) {
                if (element.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    public T[] toArray() {
        return (T[])array;
    }

    public boolean add(T o) {
        Object[] newArr = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                newArr[i] = array[i];
            }
        }
        newArr[size] = o;
        size++;
        array = newArr;
        return true;
    }

    public boolean remove(T o) {
        boolean flag = true;
        if (flag) {
            Object[] newArr = new Object[size - 1];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (array[i].equals(o)) {
                    if (flag) {
                        j--;
                        flag = false;
                    }
                } else {
                    newArr[j] = array[i];
                }
            }
        }
        return false;
    }

    public void sort(Comparator c) {
        Arrays.sort(array, c);
    }

    public void clear() {
        array = new Object[size];
    }

    public T get(int index) {
        if (index < size) {
            return (T)array[index];
        } else
            return null;
    }

    public T set(int index, T element) {
        if (index < size) {
            T o = (T)array[index];
            array[index] = element;
            return o;
        } else
            return null;
    }

    public void add(int index, T element) {
        if (index < size) {
            Object[] newArray = new Object[size++];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = element;
            for (int i = index + 1; i < size; i++) {
                newArray[i] = array[i - 1];
            }
        } else {
            array[size] = index;
        }
    }

    public T remove(int index) {
        T o = null;
        if (index < size) {
            o = (T)array[index];
            remove(o);
        }
        return o;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T o : c) {
            add(o);
        }
        return true;
    }

    public boolean removeAll(Collection<? extends T> c) {
        boolean flag = true;
        for (T o : c) {
            flag = remove(o);
        }
        return flag;
    }

    public boolean containsAll(Collection<? extends T> c) {
        for (T o : c) {
            contains(o);
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T> {
        int next = 0;
        int prev = -1;

        public boolean hasNext() {
            return next <= size();
        }

        public T next() {
            int i = next;
            T nextElement = get(i);
            prev = i;
            next = i + 1;
            return nextElement;
        }

        public void remove() {
            if (prev < 0) {
                throw new IllegalStateException();
            }

            MyArrayList.this.remove(prev);
            if (prev < next) {
                next--;
            }
            prev = -1;
        }
    }
}
