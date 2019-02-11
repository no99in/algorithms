package Main;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		BigInteger n = new BigInteger(sc.next());

		BigInteger res = coreAlgo(n);

		System.out.print(res);

	}

	/**
	 * Java大数类
	 * */
	static BigInteger coreAlgo(BigInteger n) {
		BigInteger res = (n.multiply((n.add(new BigInteger("1")))))
				.divide(new BigInteger("2"));
		return res;
	}
}
