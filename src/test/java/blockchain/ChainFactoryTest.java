package test.java.blockchain;

import main.java.blockchain.Chain;
import main.java.blockchain.ChainFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class ChainFactoryTest {
    private Chain<String, String> sut;

    @BeforeEach
    void initialize() {
        sut = ChainFactory.createSHA256StringChain();
    }

    @Test
    void itWorks() {
        Assertions.assertEquals(sut.getHeight(), BigInteger.ZERO);

        sut.chain("First block");
        Assertions.assertEquals(sut.getHeight(), BigInteger.ONE);

        sut.chain("Second block");
        Assertions.assertEquals(sut.getHeight(), BigInteger.TWO);

        sut.chain("Third block");
        Assertions.assertEquals(sut.getHeight(), BigInteger.valueOf(3));

        Assertions.assertEquals("Third blockSecond blockFirst block", sut.reduce("", String::concat));
    }
}