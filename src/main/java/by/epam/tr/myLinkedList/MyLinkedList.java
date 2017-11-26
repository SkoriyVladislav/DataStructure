package by.epam.tr.myLinkedList;


import by.epam.tr.MyList;

import java.util.*;

public class MyLinkedList implements MyList, Iterable {
    private int size = 0;

    private static class Entity {
        Object item;
        Entity next;
        Entity prev;

        Entity(Entity prev, Object element, Entity next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList.Entity first;
    public MyLinkedList.Entity last;


    public MyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return false;
        else
            return true;
    }

    public boolean contains(Object o) {
        Entity x = first;
        for (int i = 0; i < size; i++) {
            if (x.item == o) {
                return true;
            }
            x = first.next;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Entity x = first;
        for (int i = 0; i < size; i++) {
            arr[i] = x.item;
            x = first.next;
        }
        return arr;
    }

    public boolean remove(Object o) {
        boolean flag = true;
        Entity x = first;
        for (int i = 0; i < size; i++) {
            if (x.item.equals(o)) {
                unlink(x);
            }
            x = first.next;
        }
        return !flag;
    }

    public boolean addAll(Collection c) {
        for (Object entity : c) {
            this.add(entity);
        }
        return false;
    }

    public void clear() {
        for (Entity x = first; x != null; ) {
            Entity next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        String str = "";
        Entity x = first;
        for (int i = 0; i < size; i++) {
            str += x.item.toString() + " ";
            x = x.next;
        }
        return str;
    }

    private void linkFirst(Object e) {
        final Entity f = first;
        final Entity newEntity = new Entity(null, e, f);
        first = newEntity;
        if (f == null)
            last = newEntity;
        else
            f.prev = newEntity;
        size++;
    }

    private boolean linkLast(Object e) {
        final Entity l = last;
        final Entity newEntity = new Entity(l, e, null);
        last = newEntity;
        if (l == null)
            first = newEntity;
        else
            l.next = newEntity;
        size++;
        return true;
    }

    public void addFirst(Object obj) {
        linkFirst(obj);
    }

    public void add(int index, Object element) {
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, Entity(index));
    }

    public boolean add(Object element) {
        if (linkLast(element))
            return true;
        else
            return false;
    }

    private Entity Entity(int index) {
        if (index < (size >> 1)) {
            Entity x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Entity x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void linkBefore(Object e, Entity succ) {
        final Entity pred = succ.prev;
        final Entity newEntity = new Entity(pred, e, succ);
        succ.prev = newEntity;
        if (pred == null)
            first = newEntity;
        else
            pred.next = newEntity;
        size++;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Entity x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Entity x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public Object get(int index) {
        return Entity(index).item;
    }

    public Object set(int index, Object element) {
        if (index < size) {
            Entity x = Entity(index);
            Object oldVal = x.item;
            x.item = element;
            return oldVal;
        } else
            return -1;
    }

    public Object remove(int index) {
        return unlink(Entity(index));
    }

    Object unlink(Entity x) {
        Object element = x.item;
        Entity next = x.next;
        Entity prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public Iterator iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator{
        int next = 0;
        int present = -1;

        public boolean hasNext() {
            return next < size();
        }

        public Object next() {
            int i = next;
            Object nextElement = get(i);
            present = i;
            next++;
            return nextElement;
        }

        public void remove() {
            if (present > 0) {
                MyLinkedList.this.remove(present);
                next--;
                present = -1;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
