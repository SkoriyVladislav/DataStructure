package myLinkedListTest;

import by.epam.tr.linkedlist.LinkedListCustom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class LinkedListCustomTest {
    @Test
    public void testContains() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("string");
        myLinkedList.add("string3");
        myLinkedList.add("string1");
        myLinkedList.add("miracle");
        assertEquals(myLinkedList.contains("miracle"), true);
    }

    @Test
    public void testIndexOf() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("miracle");
        assertEquals(myLinkedList.indexOf("miracle"), 0);
    }

    @Test
    public void testRemove() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        assertEquals(myLinkedList.remove(1), "string");
    }

    @Test
    public void testGet() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        assertEquals(myLinkedList.get(1), "string");
    }

    @Test
    public void testSet() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("miracle");
        myLinkedList.set(0, "string");
        assertEquals(myLinkedList.get(0), "string");
    }

    @Test
    public void testIterator() {

        LinkedListCustom myLinkedList = new LinkedListCustom();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        Iterator iterator = myLinkedList.iterator();
        iterator.next();
        assertEquals(iterator.next(), "string");
    }
}
