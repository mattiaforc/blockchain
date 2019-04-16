package main.java.blockchain.tree;

import java.util.function.Consumer;

public class Node<H> implements HashTree<H> {
    private H hash;
    private HashTree<H> left;
    private HashTree<H> right;

    Node(H hash, HashTree<H> left, HashTree<H> right) {
        assert (null != left);
        assert (null != right);
        this.hash = hash;
        this.left = left;
        this.right = right;
    }

    public HashTree<H> getLeft() {
        return left;
    }

    public HashTree<H> getRight() {
        return right;
    }

    @Override
    public void visitPreOrder(Consumer<H> f) {
        f.accept(hash);
        left.visitPreOrder(f);
        right.visitPreOrder(f);
    }

    @Override
    public void visitInOrder(Consumer<H> f) {
        left.visitInOrder(f);
        f.accept(hash);
        right.visitInOrder(f);
    }

    @Override
    public void visitPostOrder(Consumer<H> f) {
        left.visitPostOrder(f);
        right.visitPostOrder(f);
        f.accept(hash);
    }

    @Override
    public H getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "Node(" + left.toString() + ", " + right.toString() + ")";
    }
}
