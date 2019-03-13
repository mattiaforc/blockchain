package main.java.blockchain;

public class HashPointer<T, H> {
    private Block<T, H> block;
    private H hash;

    public HashPointer(Block<T, H> block, H hash) {
        assert (null != block);
        this.block = block;
        this.hash = hash;
    }

    public Block<T, H> getBlock() {
        return block;
    }

    public H getHash() {
        return hash;
    }
}