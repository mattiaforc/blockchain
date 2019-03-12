package blockchain;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;
import blockchain.Block;

public class BlockBuilder<T> {
	public BlockBuilder() {
		this.id = UUID.randomUUID();
		this.previous = Optional.empty();
	}
	
	public BlockBuilder<T> setHeight(BigInteger height) {
		assert(null != height && height.compareTo(BigInteger.ZERO) >= 0);
		this.height = height;
		return this;
	}
	
	public BlockBuilder<T> setPrevious(HashPointer<T> previous) {
		assert(null != previous);
		this.previous = Optional.of(previous);
		return this;
	}
	
	public BlockBuilder<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	public Block<T> build() {
		return new Block<T>(this.id, this.height, this.data, this.previous);
	}
	
	private T data;
	private UUID id;
	private BigInteger height;
	private Optional<HashPointer<T>> previous;
}