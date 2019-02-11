package Main;

public class Main {

	public static int fun(int n) {
		return 3 * n + 9;
	}

	public static int coreAlgo(int a, int b) {

		int res = fun(a) * fun((a + b) / 2);
		int mid = (a + b) / 2;
		if (res == 0) {
			return mid;
		}
		if (res > 0) {
			mid = coreAlgo(mid, b);
		} else {
			mid = coreAlgo(a, mid);
		}

		return mid;
	}

	public static void main(String[] args) {
		System.out.println(coreAlgo(-5, 3));
	}

}
