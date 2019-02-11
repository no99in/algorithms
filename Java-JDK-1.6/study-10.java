package Main;

public class Main {

	public static int choice(int[][] dist, int process, int min, int[][] line,
			int[][] en, int chiose) {
		
		// exit
		if (process == 5) {

			return min;
		}

		// last 
		int last = 0;
		int el = 1;
		if(line[0][process] == 1) {last = 0; }
		if(line[1][process] == 1) {last = 1; el = 0;}
		
		// best and save the result
		if (line[last][process + 1] > line[el][process + 1] + en[el][process + 1]) {

			System.out.println(el);
			min = choice(dist, process + 1, min, line, en, el);

		}else{
			System.out.println(last);
			min = choice(dist, process + 1, min, line, en, last);

		}
		
		// algorithm end
		return min;

	}

	public static void main(String[] args) {
		int[][] dist = new int[2][6];
		int[][] line = { { 7, 9, 3, 4, 8, 4 }, { 8, 5, 6, 4, 5, 7 } };
		int[][] en = { { 2, 2, 1, 2, 2, 1 }, { 4, 2, 3, 1, 3, 4 } };
		int min = choice(dist, 0, 999, line, en, 0);
		System.out.println(min);
	}

}
