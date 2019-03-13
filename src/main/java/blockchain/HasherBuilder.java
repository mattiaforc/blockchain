package main.java.blockchain;

public class HasherBuilder<T, H> {
    private Eq<T> e;
    private Hash<T, H> h;

    public HasherBuilder(Eq<T> e, Hash<T, H> h) {
        assert (null != e);
        assert (null != h);
        this.h = h;
        this.e = e;
    }

    public void setComparator(Eq<T> e) {
        assert (null != e);
        this.e = e;
    }

    public void setHash(Hash<T, H> h) {
        assert (null != h);
        this.h = h;
    }

    public Hasher<T, H> build() {
        assert (null != this.h);
        assert (null != this.e);
        return new DelegateHasher<>(this.e, this.h);
    }
}