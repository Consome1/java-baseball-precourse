package baseball;

import java.util.Scanner;

import utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        game();

    }//end main

    public static void game() {
        Answer ans = new Answer();
        char[] answer;

        boolean isTrue = true;

        while (isTrue) {
            answer = ans.charAns();
            System.out.println(answer);

            break;
        }


    }
}
