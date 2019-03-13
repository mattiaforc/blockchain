package main.java.blockchain.hasher;

public class HasherBuilder<T, H> {
    private Hasher.Eq<T> e;
    private Hasher.Join<H> j;
    private Hasher.Hash<T, H> h;

    public HasherBuilder(Hasher.Eq<T> e, Hasher.Hash<T, H> h, Hasher.Join<H> j) {
        assert (null != e);
        assert (null != h);
        assert (null != j);
        this.h = h;
        this.e = e;
        this.j = j;
    }

    public void setComparator(Hasher.Eq<T> e) {
        assert (null != e);
        this.e = e;
    }

    public void setHash(Hasher.Hash<T, H> h, Hasher.Join<H> j) {
        assert (null != h);
        assert (null != j);
        this.h = h;
        this.j = j;
    }

    public Hasher<T, H> build() {
        assert (null != this.h);
        assert (null != this.e);
        assert (null != this.j);
        return new DelegateHasher<>(this.e, this.h, this.j);
    }
}