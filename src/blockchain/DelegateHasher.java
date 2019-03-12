package blockchain;

public class DelegateHasher<T> implements Hasher<T> {
	@Override
	public boolean equals(T a, T b) {
		return e.equals(a, b);
	}
	
	@Override
	public int hash(T obj) {
		return h.hash(obj);
	}
	
	private Eq<T> e;
	private Hash<T> h;
	
	DelegateHasher(Eq<T> e, Hash<T> h) {
		assert(null != e);
		assert(null != h);
		this.e = e;
		this.h = h;
	}
}