package myTree;

import by.epam.tr.binarytree.Node;
import by.epam.tr.binarytree.TreeCustom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeCustomTest {
    @Test
    public void testAdd() {

        TreeCustom<Integer, String> myTree = new TreeCustom<Integer, String>();
        myTree.add(50, "50");
        myTree.add(25, "25");
        myTree.add(30, "30");
        assertEquals(myTree.findNode(50).getValue(), "50");
    }

    @Test
    public void testRemove() {

        TreeCustom<Integer, String> myTree = new TreeCustom<Integer, String>();
        myTree.add(50, "50");
        myTree.add(25, "25");
        myTree.add(30, "30");
        myTree.remove(30);
        myTree.remove(25);
        myTree.remove(50);
        assertEquals(myTree.isEmpty(), true);
    }

    @Test
    public void testRemoveRoot() {

        TreeCustom<Integer, String> myTree = new TreeCustom<Integer, String>();
        myTree.add(50, "50");
        myTree.add(25, "25");
        myTree.add(30, "30");
        myTree.remove(50);
        assertEquals(myTree.isEmpty(), false);
    }

    @Test
    public void testIterator() {

        TreeCustom<Integer, String> myTree = new TreeCustom<Integer, String>();
        myTree.add(50, "50");
        myTree.add(25, "25");
        myTree.add(30, "30");
        myTree.add(60, "60");
        Iterator iterator = myTree.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(iterator.next(), "30");
    }

    @Test
    public void testGet() {
        TreeCustom<Integer, String> tree = new TreeCustom<>();
        tree.add(0, "zero");
        tree.add(1, "one");
        tree.add(2, "two");
        tree.add(3, "three");

        String value1 = tree.get(1);
        String value2 = tree.get(2);
        assertEquals("one", value1);
        assertEquals("two", value2);
    }

    @Test
    public void testIterator2() {
        TreeCustom<Integer, String> tree1 = new TreeCustom<>();
        tree1.add(0, "zero");
        tree1.add(1, "one");
        tree1.add(2, "two");
        tree1.add(3, "three");

        Iterator iterator1 = tree1.iterator();

        TreeCustom<Integer, String> tree2 = new TreeCustom<>();

        int size = 0;
        while (iterator1.hasNext()) {
            tree2.add(size++, iterator1.next().toString());
        }

        for (int i = 0; i < size; i++) {
            assertEquals(tree1.get(i), tree2.get(i));
        }
    }

    @Test
    public void inOrderTraverseTree() {
        TreeCustom<Integer, String> tree = new TreeCustom<>();
        String[] arr = {"zero", "one", "two", "three", "five", "seven"};

        tree.add(1, "one");
        tree.add(3, "three");
        tree.add(7, "seven");
        tree.add(0, "zero");
        tree.add(5, "five");
        tree.add(2, "two");

        List<Node> listNodes = new ArrayList<>(6);
        tree.inOrderTraverseTree(tree.root, listNodes);
        int i = 0;
        for (Node node : listNodes) {
            assertEquals(node.getValue(), arr[i++]);
        }
    }

    @Test
    public void preorderTraverseTree() {
        TreeCustom<Integer, String> tree1 = new TreeCustom<>();
        String[] arr = {"one", "zero", "three", "two",  "seven", "five"};

        tree1.add(1, "one");
        tree1.add(3, "three");
        tree1.add(7, "seven");
        tree1.add(0, "zero");
        tree1.add(5, "five");
        tree1.add(2, "two");

        List<Node> listNodes = new ArrayList<>(6);
        tree1.preorderTraverseTree(tree1.root, listNodes);
        int i = 0;
        for (Node node : listNodes) {
            assertEquals(node.getValue(), arr[i++]);
        }
    }

    @Test
    public void postOrderTraverseTree() {
        TreeCustom<Integer, String> tree1 = new TreeCustom<>();
        String[] arr = {"zero", "two", "five", "seven",  "three", "one"};

        tree1.add(1, "one");
        tree1.add(3, "three");
        tree1.add(7, "seven");
        tree1.add(0, "zero");
        tree1.add(5, "five");
        tree1.add(2, "two");

        List<Node> listNodes = new ArrayList<>(6);
        tree1.postOrderTraverseTree(tree1.root, listNodes);
        int i = 0;
        for (Node node : listNodes) {
            assertEquals(node.getValue(), arr[i++]);
        }
    }
}
