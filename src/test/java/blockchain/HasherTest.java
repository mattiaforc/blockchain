package test.java.blockchain;

import main.java.blockchain.Eq;
import main.java.blockchain.Hash;
import main.java.blockchain.Hasher;
import main.java.blockchain.HasherBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HasherTest {
    static private final String a = "LoReM";
    static private final String b = "lorem";
    static private final Eq<String> defaultComparator = (String a, String b) -> false;
    static private final Hash<String, Integer> defaultHash = (String a) -> 0xcafe;
    private Hasher<String, Integer> sut = null;
    private HasherBuilder<String, Integer> hasherBuilder = new HasherBuilder<>(defaultComparator, defaultHash);

    @BeforeEach
    void resetBuilder() {
        hasherBuilder.setHash(defaultHash);
        hasherBuilder.setComparator(defaultComparator);
    }

    @Test
    void itWorks1() {
        hasherBuilder.setHash(String::hashCode);
        hasherBuilder.setComparator(String::equals);
        sut = hasherBuilder.build();

        test();

        Assertions.assertFalse(sut.equals(a, b));
        Assertions.assertFalse(sut.equals(b, a));
    }

    @Test
    void itWorks2() {
        hasherBuilder.setHash(String::hashCode);
        hasherBuilder.setComparator(String::equalsIgnoreCase);
        sut = hasherBuilder.build();

        test();

        Assertions.assertTrue(sut.equals(a, b));
        Assertions.assertTrue(sut.equals(b, a));
    }

    private void test() {
        Assertions.assertEquals(sut.hash(a), sut.hash(a));
        Assertions.assertEquals(sut.hash(b), sut.hash(b));

        Assertions.assertNotEquals(sut.hash(a), sut.hash(b));
        Assertions.assertNotEquals(sut.hash(b), sut.hash(a));

        Assertions.assertTrue(sut.equals(a, a));
        Assertions.assertTrue(sut.equals(b, b));
    }
}