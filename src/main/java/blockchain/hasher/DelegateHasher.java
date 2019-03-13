package main.java.blockchain.hasher;

public class DelegateHasher<T, H> implements Hasher<T, H> {
    private Eq<T> e;
    private Join<H> j;
    private Hash<T, H> h;

    public DelegateHasher(Eq<T> e, Hash<T, H> h, Join<H> j) {
        assert (null != e);
        assert (null != h);
        assert (null != j);
        this.e = e;
        this.h = h;
        this.j = j;
    }

    @Override
    public boolean equals(T a, T b) {
        return e.equals(a, b);
    }

    @Override
    public H hash(T obj) {
        return h.hash(obj);
    }

    @Override
    public H join(H h1, H h2) {
        return j.join(h1, h2);
    }
}