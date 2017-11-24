package myArrayListTest;

import by.epam.tr.myArrayList.MyArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class myArrayListTest {
    @Test
    public void testContains() {
        // Проверяемый метод
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("miracle");
        assertEquals(myArrayList.contains("miracle"), true);
    }

    @Test
    public void testIndexOf() {
        // Проверяемый метод
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("miracle");
        assertEquals(myArrayList.indexOf("miracle"), 0);
    }

    @Test
    public void testRemove() {
        // Проверяемый метод
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        assertEquals(myArrayList.remove(1), "string");
    }

    @Test
    public void testGet() {
        // Проверяемый метод
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("miracle");
        myArrayList.add("string");
        assertEquals(myArrayList.get(1), "string");
    }

    @Test
    public void testSet() {
        // Проверяемый метод
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myArrayList.add("miracle");
        myArrayList.set(0, "string");
        assertEquals(myArrayList.get(0), "string");
    }
}
