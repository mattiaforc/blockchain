package main.java.blockchain;

public interface Unit<T> {
    T getInstance();
//    H getHash();
}

//class StringUnit implements Unit<String, byte[]> {
//    static private final String instance = "";
//    static private final byte[] hash = [];
//
//    @Override
//    public String getInstance() {
//        return instance;
//    }
//
//    @Override
//    public byte[] getHash() {
//
//    }
//}