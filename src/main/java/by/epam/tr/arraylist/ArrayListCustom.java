package by.epam.tr.arraylist;
import by.epam.tr.MyList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ArrayListCustom<T> implements MyList<T>, Iterable<T> {
    private static final Logger logger = LogManager.getLogger(ArrayListCustom.class);
    private Object[] array;
    private int size;

    public <T> ArrayListCustom() {
        array = new Object[size];
        size = 0;
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
        Object[] newArr = new Object[size];
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

        array = Arrays.copyOfRange(newArr, 0, size - 1);
        return !flag;
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
        } else {
            logger.log(Level.ERROR, "Index < 0");
            return null;
        }
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
        if (index < 0) {
            logger.log(Level.ERROR, "Index < 0");
        }
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

    @Override
    public String toString() {
        return "ArrayListCustom{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T> {
        int next = 0;
        int present = -1;

        public boolean hasNext() {
            return next < size();
        }

        public T next() {
            int i = next;
            T nextElement = get(i);
            present = i;
            next++;
            return nextElement;
        }

        public void remove() {
            if (present > 0) {
                ArrayListCustom.this.remove(present);
                next--;
                present = -1;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
