package main.java.blockchain.tree;

import main.java.blockchain.hasher.MerkleDelegateHasher;
import main.java.blockchain.unit.Initializer;
import main.java.blockchain.unit.Unit;

public class MerkleTree<M, T> {
    Node root;
    Unit<M, T> unit;
    MerkleDelegateHasher<M, T> hasher;

    public MerkleTree(Initializer initializer, MerkleDelegateHasher<M, T> hasher) {
        assert (null != initializer);
        this.unit = new Unit<M, T>(initializer);
        root = new Node(unit.getData());
    }

    public M getMerkleRoot() {
        return hash(root);
    }

    private M hash(Node current) {
        if (current != null) {
            return hasher.concatenateMerkleHash(hash(current.left), hash(current.right));
        } else {
            return unit.getHash();
        }
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, T data) {
        if (null == current) {
            return new Node(data);
        }
        if (null == current.left) {
            current.left = addRecursive(current.left, data);
        } else if (null == current.right) {
            current.right = addRecursive(current.right, data);
        }
        if (null == current.left.left) {
            current.left.left = addRecursive(current.left.left, data);
        } else if (null == current.left.right) {
            current.left.right = addRecursive(current.left.right, data);
        } else if (null == current.right.left) {
            current.right.left = addRecursive(current.right.left, data);
        } else if (null == current.right.right) {
            current.right.right = addRecursive(current.right.right, data);
        }
        return current;
    }

    private class Node {
        private T data;
        private Node left;
        private Node right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
