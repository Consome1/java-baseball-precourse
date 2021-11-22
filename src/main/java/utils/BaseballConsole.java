package utils;

import java.util.Scanner;

public class BaseballConsole {

    public static void main(String[] args) {
        input();
    }

    public static char[] input() {
        Scanner sc = new Scanner(System.in);
        boolean isFinish = false;
        char[] charInput = null;

        while (isFinish == false) {
            System.out.println("숫자를 입력해주세요:");
            String input= sc.nextLine();

            try {
                makeException(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                continue;
            }

            charInput = input.toCharArray();

            break;
        }

        return charInput;
    }

    public void print() {


    }

    public static void makeException(String e) throws IllegalArgumentException {

        if(e.length() !=3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }

        char[] charArr = e.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i]) == false) {
                throw new IllegalArgumentException("숫자만 입력해 주세요");
            }
        }
    }
}
