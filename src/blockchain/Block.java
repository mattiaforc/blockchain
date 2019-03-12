/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

import java.math.BigInteger;
import java.util.Optional;

public class Block<T> {	
	Block(BigInteger height, T data, Optional<HashPointer<T>> previous) {
		assert(null != data);
		assert(null != height);
		assert(null != previous);
		this.previous = previous;
		this.height = height;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public BigInteger getHeight() {
		return height;
	}
	
	public Optional<HashPointer<T>> getPrevious() {
		return previous;
	}
	
	private T data;
	private BigInteger height;
	private Optional<HashPointer<T>> previous;
}