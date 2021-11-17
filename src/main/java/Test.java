import java.util.Scanner;

import utils.RandomUtils;

public class Test {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		int answer = RandomUtils.nextInt(100, 1000);
		boolean isFinish = false;
		String input;
		
		String strAns = Integer.toString(answer);
		char[] charAns = strAns.toCharArray();
		
		char[] test = {'1', '2', '1'};
		System.out.println(checkAns(test));
		
		

	}// end main

	public static int checkAns(char[] charAns) {
		int check = 0;
		int checkZero = 1;
		
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				check = Character.compare(charAns[i], charAns[j]);
				checkZero = check * checkZero;
			}
		}

		return checkZero;
	}

}
