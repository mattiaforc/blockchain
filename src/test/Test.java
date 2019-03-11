/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package test;

import blockchain.*;

public class Test {

	public static void main(String[] args) {
		Chain chain;
		chain = new Chain(new String("First string - Hello!"));
		chain.addBlock(new String("Second block"));
		chain.addBlock(new String("Third block"));
		chain.addBlock(new String("Forth block"));
		chain.addBlock(1234);
		chain.addBlock(new String("Sixth block"));
		chain.addBlock(new String("Seventh block"));
		chain.inspectChain();
	}
}
