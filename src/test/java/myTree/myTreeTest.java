package myTree;

import by.epam.tr.binaryTree.MyTree;
import by.epam.tr.binaryTree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class myTreeTest {
    @Test
    public void testAdd() {
        // Проверяемый метод
        MyTree<Integer, String> MyTree = new MyTree<Integer, String>();
        MyTree.addNode(50, "50");
        assertEquals(MyTree.findNode(50).getValue(), "50");
    }
}
