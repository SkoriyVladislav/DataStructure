package myLinkedListTest;

import by.epam.tr.myLinkedList.MyLinkedList;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class myLinkedListTest {
    @Test
    public void testContains() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList ();
        myLinkedList.add("string");
        myLinkedList.add("string3");
        myLinkedList.add("string1");
        myLinkedList.add("miracle");
        assertEquals(myLinkedList.contains("miracle"), true);
    }

    @Test
    public void testIndexOf() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("miracle");
        assertEquals(myLinkedList.indexOf("miracle"), 0);
    }

    @Test
    public void testRemove() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        assertEquals(myLinkedList.remove(1), "string");
    }

    @Test
    public void testGet() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        assertEquals(myLinkedList.get(1), "string");
    }

    @Test
    public void testSet() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("miracle");
        myLinkedList.set(0, "string");
        assertEquals(myLinkedList.get(0), "string");
    }

    @Test
    public void testIterator() {
        // Проверяемый метод
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("miracle");
        myLinkedList.add("string");
        Iterator iterator = myLinkedList.iterator();
        iterator.next();
        assertEquals(iterator.next(), "string");
    }
}
