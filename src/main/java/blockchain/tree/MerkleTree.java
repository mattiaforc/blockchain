package main.java.blockchain.tree;

import main.java.blockchain.hasher.MerkleHasher;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MerkleTree<H, T> implements HashTree<H> {
    private HashTree<H> root;

    public MerkleTree(MerkleHasher<H, T> hasher, Stream<T> items) {
        assert (null != hasher);

        var leaves = items
                .<HashTree<H>>map(o -> new Leaf<>(hasher.computeHash(o)))
                .collect(Collectors.toCollection(ArrayList::new));

        for (var counter = new AtomicInteger(0); leaves.size() > 1; counter.setPlain(0)) {
            var stack = leaves
                    .stream()
                    .collect(Collectors.groupingBy(i -> counter.getAndIncrement() / 2))
                    .values();

            leaves = stack
                    .stream()
                    .map(l -> (l.size() == 1) ? l.get(0) : new Node<>(hasher.concatenateHash(l.get(0).getHash(), l.get(1).getHash()), l.get(0), l.get(1)))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        // TODO: Empty array -> Unit.getHash()
        if (leaves.isEmpty()) {
            root = null;
        } else {
            root = leaves.get(0);
        }
    }

    @Override
    public void visitPreOrder(Consumer<H> f) {
        root.visitPreOrder(f);
    }

    @Override
    public void visitInOrder(Consumer<H> f) {
        root.visitInOrder(f);
    }

    @Override
    public void visitPostOrder(Consumer<H> f) {
        root.visitPostOrder(f);
    }

    @Override
    public H getHash() {
        return root.getHash();
    }
}
