/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public class Block<T> {
	
	public class Builder {
		public Builder() {
			this.id = UUID.randomUUID();
			this.previous = Optional.empty();
		}
		
		public Builder setHeight(BigInteger height) {
			assert(null != height && height.compareTo(BigInteger.ZERO) >= 0);
			this.height = height;
			return this;
		}
		
		public Builder setPrevious(HashPointer<T> previous) {
			assert(null != previous);
			this.previous = Optional.of(previous);
			return this;
		}
		
		public Builder setData(T data) {
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
	
	private Block(UUID id, BigInteger height, T data, Optional<HashPointer<T>> previous) {
		assert(null != id);
		assert(null != data);
		assert(null != height);
		assert(null != previous);
		this.previous = previous;
		this.height = height;
		this.data = data;
		this.id = id;
	}
	
	public T getData() {
		return data;
	}
	public UUID getId() {
		return id;
	}
	public BigInteger getHeight() {
		return height;
	}
	public Optional<HashPointer<T>> getPrevious() {
		return previous;
	}
	
	private T data;
	private UUID id;
	private BigInteger height;
	private Optional<HashPointer<T>> previous;
}