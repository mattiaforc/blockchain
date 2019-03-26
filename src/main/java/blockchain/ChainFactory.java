package main.java.blockchain;

import main.java.blockchain.hasher.DelegateHasher;
import main.java.blockchain.hasher.Hasher;
import main.java.blockchain.unit.Initializer;
import main.java.blockchain.unit.Unit;

public class ChainFactory {
    private final static Hasher<String, String, String> SHA256StringHasher = new DelegateHasher<>(
            Utils::getSHA256String,
            (h, k) -> Utils.getSHA256String(h + k),
            () -> Utils.getSHA256String("")
    );

    static public <H, K, T> Chain<H, K, T> create(Hasher<H, K, T> hasher, Initializer<H, T> initializer, Eq<T> eq) {
        return new Chain<>(hasher, new Unit<>(initializer), eq).generateGenesis();
    }

    static public Chain<String, String, String> createSHA256StringChain(Initializer<String, String> initializer) {
        return create(SHA256StringHasher, initializer, String::equals);
    }
}