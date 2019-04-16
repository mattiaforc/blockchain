package main.java.blockchain.hasher;

public class MerkleDelegateHasher<M, T> implements MerkleHasher<M, T> {
    private MerkleHasher.MerkleDataHasher<M, T> merkleHasher;
    private MerkleHasher.MerkleJoiner<M> merkleJoiner;

    public MerkleDelegateHasher(MerkleHasher.MerkleDataHasher<M, T> hasher, MerkleHasher.MerkleJoiner<M> joiner) {
        assert (hasher != null);
        assert (joiner != null);
        this.merkleHasher = hasher;
        this.merkleJoiner = joiner;
    }

    @Override
    public M computeDataHash(T data) {
        return merkleHasher.computeDataHash(data);
    }

    @Override
    public M concatenateMerkleHash(M h1, M h2) {
        return merkleJoiner.concatenateMerkleHash(h1, h2);
    }
}
