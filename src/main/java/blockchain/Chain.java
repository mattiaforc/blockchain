package main.java.blockchain;

import main.java.blockchain.hasher.Hasher;

import java.math.BigInteger;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Chain<T, H> {
    private HashPointer<T, H> head;
    private Hasher<T, H> hasher;
    private Unit<T> unit;

    Chain(Hasher<T, H> hasher, Unit<T> unit) {
        assert (null != hasher);
        assert (null != unit);
        this.hasher = hasher;
        this.unit = unit;
    }

    Chain<T, H> generateGenesis() {
        var genesisBlock = new Block<T, H>(BigInteger.ZERO, unit.getInstance(), null);
        head = new HashPointer<>(genesisBlock, hasher.hash(unit.getInstance()));
        return this;
    }

    public Chain<T, H> chain(T data) {
        // CHECK: head reference integrity
        var block = new Block<>(head.getBlock().getHeight().add(BigInteger.ONE), data, head);
        head = new HashPointer<>(block, hasher.join(head.getHash(), hasher.hash(data)));
        return this;
    }

    public void forEach(Consumer<Block<T, H>> c) {
        // CHECK: hp integrity
        for (var hp = Optional.ofNullable(head); hp.isPresent(); hp = hp.get().getBlock().getPrevious()) {
            c.accept(hp.get().getBlock());
        }
    }

    // TODO: Morph everything into a stream
    public void filter(Predicate<Block<T, H>> p, Consumer<Block<T, H>> c) {
        for (var hp = Optional.ofNullable(head); hp.isPresent(); hp = hp.get().getBlock().getPrevious()) {
            var block = hp.get().getBlock();

            if (p.test(block)) {
                c.accept(block);
            }
        }
    }
}