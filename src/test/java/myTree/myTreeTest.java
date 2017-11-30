package myTree;

import by.epam.tr.binaryTree.MyTree;
import by.epam.tr.binaryTree.Node;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class myTreeTest {
    @Test
    public void testAdd() {
        // Проверяемый метод
        MyTree<Integer, String> MyTree = new MyTree<Integer, String>();
        MyTree.addNode(50, "50");
        assertEquals(MyTree.findNode(50).getValue(), "50");
    }

    @Test
    public void testIterator() {
        // Проверяемый метод
        MyTree<Integer, String> MyTree = new MyTree<Integer, String>();
        MyTree.addNode(50, "50");
        MyTree.addNode(25, "25");
        MyTree.addNode(30, "30");
        MyTree.addNode(60, "60");
        Iterator iterator = MyTree.iterator();

        assertEquals(iterator.next(), "25");
    }
}
