package main.java.blockchain.tree;

import java.util.function.Consumer;

public class Leaf<H> implements HashTree<H> {
    private H hash;

    Leaf(H hash) {
        this.hash = hash;
    }

    @Override
    public void visitPreOrder(Consumer<H> f) {
        f.accept(hash);
    }

    @Override
    public void visitInOrder(Consumer<H> f) {
        f.accept(hash);
    }

    @Override
    public void visitPostOrder(Consumer<H> f) {
        f.accept(hash);
    }

    @Override
    public H getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "Leaf(" + hash.toString() + ")";
    }
}
