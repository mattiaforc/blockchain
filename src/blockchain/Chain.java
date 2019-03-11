/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package blockchain;

public class Chain {
	private HashPointer chainHead;
	
	public HashPointer getChainHead() {
		return this.chainHead;
	}
	
	public <T> Chain(T data) {
		Block root = new Block<T>(null, data);
		chainHead = new HashPointer();
		chainHead.pointedBlock = root;
		chainHead.hash = root.getThisHash();
	}
	
	public <T> void addBlock(T data) {
		HashPointer reference = new HashPointer();
		reference.hash = getChainHead().hash;
		reference.pointedBlock = getChainHead().pointedBlock;
		
		Block<T> block = new Block<T>(reference, data);
		chainHead.pointedBlock = block;
		chainHead.hash = block.getThisHash();
	}
	
	private Block inspectFromBlock(Block current) { 
		System.out.println(current.toString());
		if(null != current.getReferencedHashPointer())
		{
			System.out.print("Previous block hash: " + current.getReferencedHashPointer().hash);
			System.out.println(" ; Previous block data: " + current.getReferencedHashPointer().pointedBlock.getData());
			System.out.println("-----");
			return inspectFromBlock(current.getReferencedHashPointer().pointedBlock);
		} else return null; 
	}
	
	public void inspectChain() {
		System.out.println("CHAIN HEAD:");
		inspectFromBlock(this.getChainHead().pointedBlock);
	}
}
