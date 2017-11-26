package by.epam.tr.binaryTree;

public final class Node<K, V> {
    K key;
    V value;
    Node<K, V> leftChild;
    Node<K, V> rightChild;

    Node(K key, V name) {
        this.key = key;
        this.value = name;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public String toString() {
        return value + " has the key " + key;
    }
}
