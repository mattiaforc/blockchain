package main.java.blockchain.hasher;

public interface Hasher<T, H> {
    boolean equals(T a, T b);

    H hash(T obj);

    H join(H h1, H h2);

    interface Eq<T> {
        boolean equals(T a, T b);
    }

    interface Hash<T, H> {
        H hash(T obj);
    }

    interface Join<H> {
        /**
         * Returns a new hash calculated over the concatenation of the given two hashes.
         */
        H join(H h1, H h2);
    }
}