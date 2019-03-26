package main.java.blockchain;

import main.java.blockchain.hasher.Hasher;
import main.java.blockchain.unit.Unit;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

public class Chain<H, K, T> {
    private HashPointer<K, T> head;
    private Hasher<H, K, T> hasher;
    private Unit<H, T> unit;
    private Eq<T> eq;

    Chain(Hasher<H, K, T> hasher, Unit<H, T> unit, Eq<T> eq) {
        assert (null != hasher);
        assert (null != unit);
        assert (null != eq);
        this.hasher = hasher;
        this.unit = unit;
        this.eq = eq;
    }

    Chain<H, K, T> generateGenesis() {
        var genesisBlock = new Block<K, T>(BigInteger.ZERO, unit.getData(), null);
        head = new HashPointer<>(genesisBlock, hasher.computeBlockHash(unit.getHash(), hasher.getBlockHashUnit()));
        return this;
    }

    public Chain<H, K, T> chain(T data) {
        var block = new Block<>(head.getBlock().getHeight().add(BigInteger.ONE), data, head);
        head = new HashPointer<>(block, hasher.computeBlockHash(hasher.computeDataHash(data), head.getHash()));
        return this;
    }

    public BigInteger getHeight() {
        return this.head.getBlock().getHeight();
    }

    public Stream<HashPointer<K, T>> stream() {
        return Stream.iterate(this.head, Objects::nonNull, o -> o.getBlock().getPrevious().orElse(null));
    }
}