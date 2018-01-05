package by.epam.tr.binarytree;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TreeCustom<K, V> {
    private static final Logger logger = LogManager.getLogger(TreeCustom.class);

    public Node<K, V> root;

    private final Comparator<? super K> comparator;

    public TreeCustom() {
        comparator = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreeCustom(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public void add(K key, V name) {
        Node<K, V> newNode = new Node<K, V>(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node<K, V> focusNode = root;
            Node<K, V> parent;
            while (focusNode != null) {
                parent = focusNode;
                if (compare(focusNode.getKey(), key) == 0) {
                    parent.value = newNode.value;
                    break;
                } else {
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
    }


    public void inOrderTraverseTree(Node focusNode, List<Node> list) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild, list);
            list.add(focusNode);
            inOrderTraverseTree(focusNode.rightChild, list);
        }
    }

    public void preorderTraverseTree(Node focusNode, List<Node> list) {
        if (focusNode != null) {
            list.add(focusNode);
            preorderTraverseTree(focusNode.leftChild, list);
            preorderTraverseTree(focusNode.rightChild, list);
        }
    }

    public void postOrderTraverseTree(Node focusNode, List<Node> list) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild, list);
            postOrderTraverseTree(focusNode.rightChild, list);
            list.add(focusNode);
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
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void remove(K key) {
        Node<K, V> focusNode = root;
        Node<K, V> parent = null;
        while (focusNode != null) {
            int cmp = compare(key, focusNode.key);
            if (cmp == 0) {
                deleteNode(focusNode, parent);
                return;
            } else {
                parent = focusNode;
                focusNode = (cmp < 0) ? focusNode.leftChild : focusNode.rightChild;
            }
        }
    }

    private void deleteNode(Node<K, V> focusNode, Node<K, V> parent) {
        if (focusNode.rightChild == null) {
            if (parent == null) {
                root = focusNode.leftChild;
            } else {
                if (Objects.equals(focusNode, parent.leftChild)) {
                    parent.leftChild = focusNode.leftChild;
                } else {
                    parent.rightChild = focusNode.leftChild;
                }
            }
        } else {
            parent = null;
            Node<K, V> leftMost = focusNode.rightChild;
            while (leftMost.leftChild != null) {
                parent = leftMost;
                leftMost = leftMost.leftChild;
            }

            focusNode.key = leftMost.key;
            focusNode.value = leftMost.value;

            if (parent != null) {
                parent.leftChild = leftMost.rightChild;
            } else {
                focusNode.rightChild = leftMost.rightChild;
            }

        }
    }

    public V get(K key) {
        V value = null;
        Node<K, V> focusNode = root;
        while (focusNode != null) {
            int cmp = compare(key, focusNode.key);
            if (cmp == 0) {
                value = focusNode.value;
            }
            focusNode = (cmp < 0) ? focusNode.leftChild : focusNode.rightChild;
        }
        return value;
    }


    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        int next = 0;
        int present = -1;
        ArrayList<V> arrayList = initQue(root);

        public boolean hasNext() {
            return next < arrayList.size();
        }

        public V next() {
            int i = next;
            V nextElement = arrayList.get(i);
            present = i;
            next++;
            return nextElement;
        }

        public void remove() {
            if (present >= 0) {
                arrayList.remove(present);
                next--;
                present = -1;
            } else {
                logger.log(Level.ERROR, "IllegalStateException");
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
