package main.java.blockchain;

public interface Hash<T, H> {
    H hash(T obj);
}