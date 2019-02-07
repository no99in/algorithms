package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Scanner in = new Scanner(System.in);
	/**
	 * 作業 二分搜索 算法
	 * */
	public static boolean coreAlgo(ArrayList<Integer> al, Integer e, int beg,
			int end) {
		if (beg == end) {
			return al.get(end) == e;
		}
		int mid = beg + end / 2;
		if (e > al.get(mid)) {
			coreAlgo(al, e, mid + 1, end);
		} else if (e < al.get(mid)) {
			coreAlgo(al, e, beg, mid);
		} else {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(3);
		System.out.println(coreAlgo(al,3,0,al.size()-1));
	}

}
