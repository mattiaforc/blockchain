package main.java.blockchain;

import main.java.blockchain.hasher.Hasher;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

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
        var block = new Block<>(head.getBlock().getHeight().add(BigInteger.ONE), data, head);
        head = new HashPointer<>(block, hasher.join(head.getHash(), hasher.hash(data)));
        return this;
    }

    public BigInteger getHeight() {
        return this.head.getBlock().getHeight();
    }

    public Stream<HashPointer<T, H>> stream() {
        return Stream.iterate(this.head, Objects::nonNull, o -> o.getBlock().getPrevious().orElse(null));
    }
}