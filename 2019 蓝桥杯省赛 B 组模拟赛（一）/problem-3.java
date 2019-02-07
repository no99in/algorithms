package Main;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

		BigInteger d = new BigInteger("234");
		BigInteger k = new BigInteger("12302135942453");
		System.out.println(k.divide(d));
		System.out.println(d.multiply(new BigInteger("5")));
	}

}
