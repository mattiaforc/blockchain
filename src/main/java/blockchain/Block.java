package main.java.blockchain;

import java.math.BigInteger;
import java.util.Optional;

public class Block<K, T> {
    private T data;
    private BigInteger height;
    private HashPointer<K, T> previous;

    Block(BigInteger height, T data, HashPointer<K, T> previous) {
        assert (null != height);
        this.data = data;
        this.height = height;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public BigInteger getHeight() {
        return height;
    }

    public Optional<HashPointer<K, T>> getPrevious() {
        return Optional.ofNullable(previous);
    }

    @Override
    public String toString() {
        return "Block(height: " + this.height + ", data: " + this.data + ")";
    }
}