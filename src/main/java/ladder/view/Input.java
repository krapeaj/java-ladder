package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static String takeNames() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String takePrizes(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String takeHeight() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.next();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            return takeHeight();
        }
    }
}