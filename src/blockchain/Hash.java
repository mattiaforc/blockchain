package blockchain;

public interface Hash<T> {
	public abstract int hash(T obj);
}