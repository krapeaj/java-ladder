package ladder.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int takeInt() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        }
        catch (InputMismatchException e){
            return 0;
        }
    }

    public static String takeString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}