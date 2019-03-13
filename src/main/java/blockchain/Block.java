package main.java.blockchain;

import java.math.BigInteger;
import java.util.Optional;

public class Block<T, H> {
    private T data;
    private BigInteger height;
    private HashPointer<T, H> previous;

    Block(BigInteger height, T data, HashPointer<T, H> previous) {
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

    public Optional<HashPointer<T, H>> getPrevious() {
        return Optional.ofNullable(previous);
    }

    @Override
    public String toString() {
        return "Block(data: " + this.data + ", hash: " + this.getPrevious().map(h -> h.getHash().toString()).orElse("") + ");";
    }
}