package blockchain;

import java.util.Optional;

public class HasherBuilder<T> {
	public Hasher<T> build(Eq<T> e, Hash<T> h) {
		return Optional.of(new DelegateHasher<T>(e, h)).get();
	}
}