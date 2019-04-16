package main.java.blockchain.hasher;

public interface MerkleHasher<M, T> {

    M computeDataHash(T data);

    M concatenateMerkleHash(M h1, M h2);

    interface MerkleDataHasher<M, T> {
        M computeDataHash(T data);
    }

    interface MerkleJoiner<M> {
        M concatenateMerkleHash(M h1, M h2);
    }
}
