package main.java.blockchain;

public interface Hash<T, H> {
	public abstract H hash(T obj);
}