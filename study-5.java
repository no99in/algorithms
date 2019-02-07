package Main;

import java.util.Scanner;

public class Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i <= 50; i++) {
			for (int j = 0; j <= 50; j++) {
				if (j * 2 + i * 4 == 120) {
					System.out.println("鸡：" + j + "兔：" + i);
				}
			}
		}
	}
}
