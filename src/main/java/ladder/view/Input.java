package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static String takeString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public static int takeInt() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("숫자를 입력해주세요.");
            return takeInt();
        }
    }


}