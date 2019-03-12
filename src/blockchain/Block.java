/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public class Block<T> {	
	Block(UUID id, BigInteger height, T data, Optional<HashPointer<T>> previous) {
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