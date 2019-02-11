package Main;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void swap(char ans[],int pos1,int pos2){
		if(pos1 != pos2){
			char temp = ans[pos1];
			ans[pos1] = ans[pos2];
			ans[pos2] = temp;
		}
	}
	/**
	 * 全排列 6个以下
	 * */
	public static void coreAlgo(char[] ans, int beg, int end) {
		if (beg == end) {
			System.out.print(ans);
			System.out.print(" ");
		}
		for(int i = beg;i <= end ;i ++){
			swap(ans,beg,i);
			coreAlgo(ans,beg+1,end);
			swap(ans,beg,i);
		}
	}

	public static void main(String[] args) {
		String str = in.next();
		char[] ans = str.toCharArray();
		coreAlgo(ans, 0, ans.length - 1);
	}
}
