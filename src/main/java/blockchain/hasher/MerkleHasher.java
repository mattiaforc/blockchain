package main.java.blockchain.hasher;

public interface MerkleHasher<M, T> {
    M computeHash(T data);

    M concatenateHash(M h1, M h2);

    interface MerkleDataHasher<M, T> {
        M computeHash(T data);
    }

    interface MerkleJoiner<M> {
        M concatenateHash(M h1, M h2);
    }
}
