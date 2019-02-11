package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int n = in.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			al.add(in.nextInt());
		}
		Collections.sort(al);
		for (int i = 0; i < n; i++) {
			if (i != n - 1)
				System.out.print(al.get(i) + " ");
			else
				System.out.println(al.get(i));
		}

	}

}
