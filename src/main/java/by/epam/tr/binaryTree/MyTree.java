package by.epam.tr.binaryTree;

import java.util.*;

public class MyTree<K, V> {
    public Node<K, V> root;

    private final Comparator<? super K> comparator;

    public MyTree() {
        comparator = null;
    }

    public MyTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public void addNode(K key, V name) {
        Node<K, V> newNode = new Node<K, V>(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node<K, V> focusNode = root;
            Node<K, V> parent;
            while (focusNode != null) {
                parent = focusNode;
                if (compare(focusNode.getKey(), key) > 0) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                    }
                }
            }
        }
    }


    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }
    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }
    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    private int compare(Object k1, Object k2) {
        int result;
        if (comparator == null) {
            result = ((Comparable<? super K>) k1).compareTo((K) k2);
        } else {
            result = comparator.compare((K) k1, (K) k2);
        }
        return result;
    }

    public Node findNode(K key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (compare(focusNode.getKey(), key) > 0) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
            return null;
        }
        return focusNode;
    }

    public Iterator<V> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<V> {
        int next = 0;
        int present = -1;
        ArrayList<V> arrayList = initQue(root);

        public boolean hasNext() {
            return next < arrayList.size();
        }

        public V next() {
            int i = next;
            V nextElement = arrayList.get(next);
            present = i;
            next++;
            return nextElement;
        }

        public void remove() {
            if (present > 0) {
                arrayList.remove(present);
                next--;
                present = -1;
            } else {
                throw new IllegalStateException();
            }
        }

        private ArrayList<V> initQue(Node<K,V> node) {
            return inOrderTraverseTree(node, new ArrayList<V>());
        }

        private ArrayList<V> inOrderTraverseTree(Node focusNode, ArrayList<V> arrayList) {
            if (focusNode != null) {
                inOrderTraverseTree(focusNode.leftChild, arrayList);
                arrayList.add((V)focusNode.getValue());
                inOrderTraverseTree(focusNode.rightChild, arrayList);
            }
            return arrayList;
        }
    }

}
