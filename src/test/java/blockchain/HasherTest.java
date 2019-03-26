package test.java.blockchain;

import main.java.blockchain.Utils;
import main.java.blockchain.hasher.DelegateHasher;
import main.java.blockchain.hasher.Hasher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HasherTest {
    static private final String a = "LoReM";
    static private final String b = "lorem";
    static private final String ha = Utils.getSHA256String(a);
    static private final String hb = Utils.getSHA256String(b);
    static private final String k = Utils.getSHA256String("Block hash");
    static private final String gk = Utils.getSHA256String("Genesis block");
    static private final String hka = Utils.getSHA256String(a + k);
    static private final String hkb = Utils.getSHA256String(b + k);

    private Hasher<String, String, String> sut = new DelegateHasher<>(Utils::getSHA256String, (h, k) -> Utils.getSHA256String(h + k), () -> gk);

    @Test
    void itWorks() {
        Assertions.assertEquals(gk, sut.getBlockHashUnit());

        Assertions.assertEquals(sut.computeDataHash(a), sut.computeDataHash(a));
        Assertions.assertEquals(sut.computeDataHash(b), sut.computeDataHash(b));

        Assertions.assertNotEquals(sut.computeDataHash(a), sut.computeDataHash(b));
        Assertions.assertNotEquals(sut.computeDataHash(b), sut.computeDataHash(a));

        Assertions.assertEquals(sut.computeDataHash(a), ha);
        Assertions.assertEquals(sut.computeDataHash(b), hb);

        Assertions.assertEquals(hka, sut.computeBlockHash(a, k));
        Assertions.assertEquals(hkb, sut.computeBlockHash(b, k));
    }
}