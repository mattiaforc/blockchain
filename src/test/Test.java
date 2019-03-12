/* Author: mattiaforc
Date: 03/11/19
Mail: mattiaforc@gmail.com */

package test;

import blockchain.*;

public class Test {	
	public static void test() {
		String a = "Lorem";
		String b = "Ipsum";
		
		var sut = new HasherBuilder<String>().build(String::equalsIgnoreCase, String::hashCode);

		assert(sut.hash(a) == sut.hash(a));
		assert(sut.hash(b) == sut.hash(b));
		assert(sut.hash(a) != sut.hash(b));
		assert(sut.hash(b) != sut.hash(a));
		
		assert(sut.equals(a,a));
		assert(sut.equals(b,b));
		assert(!sut.equals(a,b));
		assert(!sut.equals(b,a));
	}
	
	public static void main(String[] args) {
		test();
	}
}
