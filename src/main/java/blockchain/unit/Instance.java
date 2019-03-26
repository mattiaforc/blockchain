package main.java.blockchain.unit;

public class Instance<H, T> {
    H hash;
    T data;

    public Instance(H hash, T data) {
        this.hash = hash;
        this.data = data;
    }
}