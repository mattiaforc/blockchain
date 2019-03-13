package test.java.blockchain;

import main.java.blockchain.hasher.DelegateHasher;
import main.java.blockchain.hasher.Hasher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HasherTest {
    static private final String a = "LoReM";
    static private final String b = "lorem";
    private Hasher<String, Integer> sut = new DelegateHasher<>(String::equals, String::hashCode, (h1, h2) -> h1 ^ h2);

    @Test
    void itWorks() {
        Assertions.assertEquals(sut.hash(a), sut.hash(a));
        Assertions.assertEquals(sut.hash(b), sut.hash(b));

        Assertions.assertNotEquals(sut.hash(a), sut.hash(b));
        Assertions.assertNotEquals(sut.hash(b), sut.hash(a));

        Assertions.assertTrue(sut.equals(a, a));
        Assertions.assertTrue(sut.equals(b, b));

        Assertions.assertFalse(sut.equals(a, b));
        Assertions.assertFalse(sut.equals(b, a));

        Assertions.assertEquals(sut.join(sut.hash(a), sut.hash(b)), a.hashCode() ^ b.hashCode());
    }
}