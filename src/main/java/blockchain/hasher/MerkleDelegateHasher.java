package main.java.blockchain.hasher;

public class MerkleDelegateHasher<M, T> implements MerkleHasher<M, T> {
    private MerkleDataHasher<M, T> merkleHasher;
    private MerkleHasher.MerkleJoiner<M> merkleJoiner;

    public MerkleDelegateHasher(MerkleDataHasher<M, T> hasher, MerkleHasher.MerkleJoiner<M> joiner) {
        assert (hasher != null);
        assert (joiner != null);
        this.merkleHasher = hasher;
        this.merkleJoiner = joiner;
    }

    @Override
    public M computeHash(T data) {
        return merkleHasher.computeHash(data);
    }

    @Override
    public M concatenateHash(M h1, M h2) {
        return merkleJoiner.concatenateHash(h1, h2);
    }
}
