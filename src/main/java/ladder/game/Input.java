package ladder.game;

import java.util.Scanner;

public class Input {
    public static int takeInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static String takeString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}