package myArrayListTest;

import by.epam.tr.arraylist.ArrayListCustom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ArrayListCustomTest {
    @Test
    public void testContains() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        assertEquals(myArrayList.contains("miracle"), true);
    }

    @Test
    public void testIndexOf() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        assertEquals(myArrayList.indexOf("miracle"), 0);
    }

    @Test
    public void testRemove() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        assertEquals(myArrayList.remove(1), "string");
    }

    @Test
    public void testRemove2() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        assertEquals(myArrayList.remove("string312"), false);
    }

    @Test
    public void testGet() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        assertEquals(myArrayList.get(1), "string");
    }

    @Test
    public void testSet() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        myArrayList.set(0, "string");
        assertEquals(myArrayList.get(0), "string");
    }

    @Test
    public void testIterator() {

        ArrayListCustom<String> myArrayList = new ArrayListCustom<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        Iterator iterator = myArrayList.iterator();
        iterator.next();
        assertEquals(iterator.next(), "string");
    }
}
