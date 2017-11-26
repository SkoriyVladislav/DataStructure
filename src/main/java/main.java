import by.epam.tr.binaryTree.MyTree;


public class main {
    public static void main(String... args) {
        MyTree theTree = new MyTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        // Different ways to traverse binary trees
        theTree.inOrderTraverseTree(theTree.root);
        System.out.println();
        System.out.println();

        theTree.preorderTraverseTree(theTree.root);
        System.out.println();
        System.out.println();

        theTree.postOrderTraverseTree(theTree.root);
        System.out.println();
        System.out.println();
        // Find the node with key 75
        System.out.println("\nNode with the key 75");
        System.out.println(theTree.findNode(75));

    }
}
