package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		int finish = 1;

		while (finish == 1) {
			game();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			finish = scanner.nextInt();
			if (finish == 2) {
				break;
			}
		}

	}// end main

	public static void game() {
		final Scanner scanner = new Scanner(System.in);
		boolean isFinish = false;
		String input;
		char[] charAns = getAnswer();

		while (isFinish == false) {
			System.out.println("숫자를 입력해주세요 : ");
			input = scanner.nextLine();

			try {
				exception(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.toString());
				continue;
			}

			char[] charInput = input.toCharArray(); // input값을 char배열로

			/* 
			System.out.println("인풋값 :");
			for (int i = 0; i < 3; i++) {
				System.out.printf("%c ", charInput[i]);
			}

			System.out.println("정답 :");
			for (int i = 0; i < 3; i++) {
				System.out.printf("%c ", charAns[i]);
			} */
			//정답, 인풋값 확인

			switch (hint(charInput, charAns)) {
			case 1:
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				isFinish = true;
				break;
			case 2:
				System.out.printf("%d스트라이크\n", strikeNum(charInput, charAns));
				break;
			case 3:
				System.out.printf("%d볼 %d스트라이크 \n", ballNum(charInput, charAns), strikeNum(charInput, charAns));
				break;
			case 4:
				System.out.printf("%d볼\n", ballNum(charInput, charAns));
				break;
			case 5:
				System.out.println("낫싱");
				break;
			}

		}

	}// end game

	public static int hint(char[] pCharInput, char[] pCharAns) {
		int count = 0;
		int hintVal = 0;
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈

		for (int i = 0; i < 3; i++) {
			if (a[i] == b[i]) {
				count++;
			}
		}
		if (count == 3) {
			hintVal = 1;
		} // 3개 다 맞을경우 1을 반환

		if (count > 0 && count < 3) {
			if (isBall(a, b) == -1) {
				hintVal = 2;// 스트라이크만 있을 경우
			}

			if (isBall(a, b) == 1) {
				hintVal = 3; // 스트라이크 + ball
			}
			;
		} // 스트라이크 존재할경우 ball까지 확인

		if (count == 0) {
			if (isBall(a, b) == -1) {
				hintVal = 5;
			} // 스트라이크 0, ball 0이기에 바로 낫싱

			if (isBall(a, b) == 1) {
				hintVal = 4;
			} // ball만 잇는 경우

		} // 스트라이크x 볼 확인

		count = 0;

		return hintVal;

	} // end method hint

	public static int isBall(char[] pCharInput, char[] pCharAns) {
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈
		int i = 0;
		int count = 0;
		int returnVal = 0;

		while (true) {

			if (i == 3) {
				break;
			}

			if (a[i] == b[0] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[1] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[2] && a[i] != b[i]) {
				count++;
			}

			i++;

		}

		if (count > 0) {
			returnVal = 1;
		}

		if (count == 0) {
			returnVal = -1;
		}

		return returnVal;
	}// end isBall

	public static int ballNum(char[] pCharInput, char[] pCharAns) {
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈
		int i = 0;
		int count = 0;

		while (true) {

			if (i == 3) {
				break;
			}

			if (a[i] == b[0] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[1] && a[i] != b[i]) {
				count++;
			}

			if (a[i] == b[2] && a[i] != b[i]) {
				count++;
			}

			i++;

		}

		return count;
	}// end ballNum

	public static int strikeNum(char[] pCharInput, char[] pCharAns) {
		int count = 0;
		char[] a = pCharInput;
		char[] b = pCharAns; // 입력하기 쉽게 짧게 바꿈

		for (int i = 0; i < 3; i++) {
			if (a[i] == b[i]) {
				count++;
			}
		}

		return count;
	}

	public static char[] getAnswer() {
		boolean isSame = true;
		char[] charAns = new char[3];

		while (isSame) {
			int answer = RandomUtils.nextInt(100, 1000);
			String strAns = Integer.toString(answer);
			charAns = strAns.toCharArray(); // ans값을 char 배열로

			if (checkAns(charAns) != 0) {
				isSame = false;
			}
		} // 3개의 숫자가 중복되지 않을때까지 반복

		return charAns;
	} // Answer 받기

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
	}// 랜덤하게 받은 Ans값이 중복된 숫자면 0을 반환

	public static void exception(String a) throws IllegalArgumentException {
		if (a.length() != 3) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
		}

		char[] charArr = a.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			if (Character.isDigit(charArr[i]) == false) {
				throw new IllegalArgumentException("숫자만 입력해 주세요");
			}
		}
	}
}// end class Application
