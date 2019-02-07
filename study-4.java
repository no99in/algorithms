package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/**
	 * 动态规划
	 * 
	 * 
	 * 3 1 1 2 2 3 3
	 * 
	 * */
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<thing> al = new ArrayList<thing>();
		int n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			al.add(new thing(in.nextInt(), in.nextInt()));
		}
		int[][] ans = new int[10][101];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 101; j++) {
				if (i == 0) {
					if (j < al.get(i).weight)
						ans[i][j] = 0;
					else
						ans[i][j] = Math.max(0, al.get(i).value);
				} else {
					if (j < al.get(i).weight)
						ans[i][j] = ans[i - 1][j];
					else
						ans[i][j] = Math.max(ans[i - 1][j],
								ans[i - 1][j - al.get(i).weight] + al.get(i).value);
				}

			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 101; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

class thing {
	public int weight;
	public int value;

	public thing(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

}
