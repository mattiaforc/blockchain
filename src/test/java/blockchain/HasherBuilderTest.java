package test.java.blockchain;

import main.java.blockchain.HasherBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HasherBuilderTest {
    @Test
    void itWorks() {
        final String a = "Lorem";
        final String b = "Ipsum";
        final var sut = new HasherBuilder<>(String::equalsIgnoreCase, String::hashCode).build();

        Assertions.assertEquals(sut.hash(a), sut.hash(a));
        Assertions.assertEquals(sut.hash(b), sut.hash(b));

        Assertions.assertNotEquals(sut.hash(a), sut.hash(b));
        Assertions.assertNotEquals(sut.hash(b), sut.hash(a));

        Assertions.assertTrue(sut.equals(a, a));
        Assertions.assertTrue(sut.equals(b, b));

        Assertions.assertFalse(sut.equals(a, b));
        Assertions.assertFalse(sut.equals(b, a));
    }
}