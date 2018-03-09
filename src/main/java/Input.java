package ladder.game;

import java.util.Scanner;

public class Input {
    public static int takeInt(){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
       // scan.close();
        return number;
    }
}
