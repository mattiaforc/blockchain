package main.java.blockchain.tree;

import main.java.blockchain.hasher.MerkleDelegateHasher;
import main.java.blockchain.unit.Initializer;
import main.java.blockchain.unit.Unit;

public class MerkleTree<M, T> {
    Node root;
    Unit<M, T> unit;
    MerkleDelegateHasher<M, T> hasher;

    public MerkleTree(Initializer<M, T> initializer, MerkleDelegateHasher<M, T> hasher) {
        assert (null != initializer);
        assert (null != hasher);
        this.unit = new Unit<>(initializer);
        this.root = new Node(unit.getData());
    }

    public M getMerkleRoot() {
        return root.hash();
    }

    public void add(T data) {
        root.add(data);
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

        void add(T data) {
            int leftHeight = getLeftHeight();
            int rightHeight = getRightHeight();

            if (leftHeight <= rightHeight) {
                if (leftHeight > 0) {
                    left.add(data);
                } else {
                    left = new Node(data);
                }
            } else {
                if (rightHeight > 0) {
                    right.add(data);
                } else {
                    right = new Node(data);
                }
            }
        }

        M hash() {
            return hasher.concatenateMerkleHash((null == left) ? unit.getHash() : left.hash(), (null == right) ? unit.getHash() : right.hash());
        }

        int getLeftHeight() {
            return (null != left) ? 1 + left.getLeftHeight() + left.getRightHeight() : 0;
        }

        int getRightHeight() {
            return (null != right) ? 1 + right.getLeftHeight() + right.getRightHeight() : 0;
        }
    }
}
