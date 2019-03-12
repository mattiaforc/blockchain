/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package test;

import java.math.BigInteger;

import org.junit.Assert;
import blockchain.*;

class Test {	
	static void testHasherBuilder() {
		String a = "Lorem";
		String b = "Ipsum";
		
		var sut = new HasherBuilder<String>(String::equalsIgnoreCase, String::hashCode).build();

		Assert.assertEquals(sut.hash(a), sut.hash(a));
		Assert.assertEquals(sut.hash(b), sut.hash(b));
		Assert.assertNotEquals(sut.hash(a), sut.hash(b));
		Assert.assertNotEquals(sut.hash(b), sut.hash(a));
		
		Assert.assertTrue(sut.equals(a,a));
		Assert.assertTrue(sut.equals(b,b));
		Assert.assertFalse(sut.equals(a,b));
		Assert.assertFalse(sut.equals(b,a));
	}
	
	static void testBlock() {
		var hasher = new HasherBuilder<String>(String::equalsIgnoreCase, String::hashCode).build();
		
		var builder = new BlockBuilder<String>();
		builder.setHeight(BigInteger.ZERO);
		builder.setData("Lorem");
		
		var sut = builder.build();
		Assert.assertFalse(sut.getPrevious().isPresent());
		Assert.assertEquals(BigInteger.ZERO, sut.getHeight());
		Assert.assertEquals("Lorem", sut.getData());
		Assert.assertTrue(null != sut.getId());
		
		var hp = new HashPointer<String>(sut, hasher.hash(sut.getData()));
		builder.setPrevious(hp);
		builder.setData("Ipsum");
		builder.setHeight(BigInteger.ONE);
		
		sut = builder.build();
		Assert.assertTrue(sut.getPrevious().isPresent());
		Assert.assertTrue(
				sut
					.getPrevious()
					.map((HashPointer<String> _h) -> {return hp.getHash() == _h.getHash();})
					.orElse(false)
		);
		Assert.assertEquals(BigInteger.ONE, sut.getHeight());
		Assert.assertEquals("Ipsum", sut.getData());
		Assert.assertTrue(null != sut.getId());
	}
	
	public static void main(String[] args) {
		testHasherBuilder();
		testBlock();
	}
}
