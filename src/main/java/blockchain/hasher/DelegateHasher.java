package main.java.blockchain.hasher;

public class DelegateHasher<H, K, T> implements Hasher<H, K, T> {
    private BlockHashUnit<K> blockHashUnit;
    private BlockHasher<H, K> blockHasher;
    private DataHasher<H, T> dataHasher;

    public DelegateHasher(DataHasher<H, T> dataHasher, BlockHasher<H, K> blockHasher, BlockHashUnit<K> blockHashUnit) {
        assert (null != dataHasher);
        assert (null != blockHasher);
        assert (null != blockHashUnit);
        this.dataHasher = dataHasher;
        this.blockHasher = blockHasher;
        this.blockHashUnit = blockHashUnit;
    }

    @Override
    public H computeDataHash(T data) {
        return dataHasher.computeDataHash(data);
    }

    @Override
    public K computeBlockHash(H h, K k) {
        return blockHasher.computeBlockHash(h, k);
    }

    @Override
    public K getBlockHashUnit() {
        return blockHashUnit.getBlockHashUnit();
    }
}