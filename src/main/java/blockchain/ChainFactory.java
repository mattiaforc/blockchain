package main.java.blockchain;

import main.java.blockchain.hasher.Hasher;

public class ChainFactory<T, H> {
    public Chain<T, H> create(Hasher<T, H> hasher, Unit<T> unit) {
        return new Chain<>(hasher, unit).generateGenesis();
    }
}
