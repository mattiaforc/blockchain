package test.java.blockchain;

import main.java.blockchain.Utils;
import main.java.blockchain.hasher.MerkleDelegateHasher;
import main.java.blockchain.tree.MerkleTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MerkleTreeTest {
    @Test
    void itWorks() {
        var list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        var a = Utils.getSHA256String("A");
        var b = Utils.getSHA256String("B");
        var c = Utils.getSHA256String("C");
        var d = Utils.getSHA256String("D");
        var e = Utils.getSHA256String("E");
        var ab = Utils.getSHA256String(a + b);
        var cd = Utils.getSHA256String(c + d);
        var abcd = Utils.getSHA256String(ab + cd);
        var abcde = Utils.getSHA256String(abcd + e);

        var sut = new MerkleTree<>(
                new MerkleDelegateHasher<>(
                        Utils::getSHA256String,
                        (h1, h2) -> Utils.getSHA256String(h1 + h2)),
                list.stream()
        );

        Assertions.assertEquals(abcde, sut.getHash());
    }
}
