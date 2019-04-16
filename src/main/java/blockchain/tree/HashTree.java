package main.java.blockchain.tree;

import java.util.function.Consumer;

public interface HashTree<H> {
    void visitPreOrder(Consumer<H> f);

    void visitInOrder(Consumer<H> f);

    void visitPostOrder(Consumer<H> f);

    H getHash();
}

// Tree(H) = Leaf(H) | Node(Tree(H), Tree(H))
