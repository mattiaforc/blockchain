package main.java.blockchain;

public class HashPointer<K, T> {
    private Block<K, T> block;
    private K blockHash;

    public HashPointer(Block<K, T> block, K blockHash) {
        assert (null != block);
        assert (null != blockHash);
        this.block = block;
        this.blockHash = blockHash;
    }

    public Block<K, T> getBlock() {
        return block;
    }

    public K getHash() {
        return blockHash;
    }

    @Override
    public String toString() {
        return "HashPointer(hash: " + this.blockHash + ", block: " + this.block + ")";
    }
}