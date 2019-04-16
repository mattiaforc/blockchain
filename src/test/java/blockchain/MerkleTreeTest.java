package test.java.blockchain;

import main.java.blockchain.Utils;
import main.java.blockchain.hasher.MerkleDelegateHasher;
import main.java.blockchain.tree.MerkleTree;
import main.java.blockchain.unit.Instance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MerkleTreeTest {
    @Test
    void itWorks() {
        var sut = new MerkleTree<String, String>(
                () -> new Instance<>("Hash", "Data"),
                new MerkleDelegateHasher<>(
                        (h) -> h + "!H!",
                        (h1, h2) -> h1 + h2));
        sut.add("Primo");
        sut.add("Secondo");
        sut.add("Terzo");
        sut.add("Quarto");
        sut.add("Quinto");
        sut.getMerkleRoot();
        Assertions.fail();
    }
}
