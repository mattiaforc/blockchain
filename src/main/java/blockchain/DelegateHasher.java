package main.java.blockchain;

public class DelegateHasher<T, H> implements Hasher<T, H> {
    private Eq<T> e;
    private Hash<T, H> h;

    DelegateHasher(Eq<T> e, Hash<T, H> h) {
        assert (null != e);
        assert (null != h);
        this.e = e;
        this.h = h;
    }

    @Override
    public boolean equals(T a, T b) {
        return e.equals(a, b);
    }

    @Override
    public H hash(T obj) {
        return h.hash(obj);
    }
}