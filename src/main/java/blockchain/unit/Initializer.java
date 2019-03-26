package main.java.blockchain.unit;

public interface Initializer<H, T> {
    Instance<H, T> initialize();
}