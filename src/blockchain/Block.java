/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

public class Block<T> {
	private HashPointer referencedHashPointer;
	private T data;
	
	public Block(HashPointer reference, T data) {
		this.data = data; 
		this.referencedHashPointer = reference;
	}
	
	public HashPointer getReferencedHashPointer() {
		return referencedHashPointer;
	}

	public void setReferencedHashPointer(HashPointer referencedHashPointer) {
		this.referencedHashPointer = referencedHashPointer;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public String getThisHash() {
		if(null == this.getData()) return null;
		String toHash;
		if (referencedHashPointer != null) {
			toHash = new StringBuffer(referencedHashPointer.hash).append(getData().toString()).toString();
		} else {
			toHash = getData().toString();
		}
		return Utils.getSHA256String(toHash);
	}
	
	@Override
    public String toString() {
        return new StringBuffer("Hash: ").append(this.getThisHash()).append(" ; Data:").append(this.getData().toString()).toString();
    }

}
