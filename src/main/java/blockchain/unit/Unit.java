package main.java.blockchain.unit;

public class Unit<H, T> {
    private boolean uninitialized = true;
    private Initializer<H, T> initializer;
    private Instance<H, T> instance;

    public Unit(Initializer<H, T> initializer) {
        assert (null != initializer);
        this.initializer = initializer;
    }

    public H getHash() {
        return getInstance().hash;
    }

    public T getData() {
        return getInstance().data;
    }

    private Instance<H, T> getInstance() {
        if (uninitialized) {
            instance = initializer.initialize();
            assert (null != instance);
            uninitialized = false;
        }
        return instance;
    }
}