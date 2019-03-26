package main.java.blockchain.hasher;

public interface Hasher<H, K, T> {
    H computeDataHash(T data);

    K computeBlockHash(H thisDataHash, K previousBlockHash);

    K getBlockHashUnit();

    interface DataHasher<H, T> {
        H computeDataHash(T data);
    }

    interface BlockHasher<H, K> {
        K computeBlockHash(H thisDataHash, K previousBlockHash);
    }

    interface BlockHashUnit<K> {
        K getBlockHashUnit();
    }
}