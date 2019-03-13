package main.java.blockchain;

import main.java.blockchain.hasher.DelegateHasher;
import main.java.blockchain.hasher.Hasher;

public class ChainFactory {
    private final static Hasher<String, String> SHA256StringHasher = new DelegateHasher<>(
            String::equals,
            Utils::getSHA256String,
            (h1, h2) -> Utils.getSHA256String(h1 + h2)
    );

    static public <T, H> Chain<T, H> create(Hasher<T, H> hasher, Unit<T> unit) {
        return new Chain<>(hasher, unit).generateGenesis();
    }

    static public Chain<String, String> createSHA256StringChain() {
        return create(SHA256StringHasher, () -> "");
    }
}