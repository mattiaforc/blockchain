/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

public class HashPointer<T> {
	public HashPointer(Block<T> block, int hash) {
		assert(null != block);
		this.block = block;
		this.hash = hash;
	}

	public Block<T> getBlock() {
		return block;
	}

	public int getHash() {
		return hash;
	}	
	
	private Block<T> block;
	private int hash;
}
