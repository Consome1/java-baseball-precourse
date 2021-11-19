package baseball;

public class Answer {
    public int answer(int input) {
        String strAns = Integer.toString(input);
        char[] charAns = strAns.toCharArray();
        int isEqual = 0;
        int checkZero = 1;
        int check = 1;

        for(int i = 0; i <3; i ++) {
            for (int j = i + 1; j < 3; j++) {
                isEqual = Character.compare(charAns[i], charAns[j]);
                checkZero *= isEqual;
            }
        }
        if (checkZero == 0) {
            check = -1;
        }

        if (checkZero != 0) {
            check = 1;
        }

        return check;
    }
}
