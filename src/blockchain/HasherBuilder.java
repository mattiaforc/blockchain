package blockchain;

public class HasherBuilder<T> {
	public HasherBuilder(Eq<T> e, Hash<T> h) {
		assert(null != e);
		assert(null != h);
		this.h = h;
		this.e = e;
	}
	
	public void setComparator(Eq<T> e) {
		assert(null != e);
		this.e = e;
	}
	
	public void setHash(Hash<T> h) {
		assert(null != h);
		this.h = h;
	}
	
	public Hasher<T> build() {
		assert(null != this.h);
		assert(null != this.e);
		return new DelegateHasher<T>(this.e, this.h);
	}
	
	private Eq<T> e;
	private Hash<T> h;
}