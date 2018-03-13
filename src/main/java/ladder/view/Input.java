package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final int CHAR_LIMIT = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;

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

    public static boolean isNotValidString(String nameString) {
        String[] names = nameString.split(",");

        return isNotEnoughNames(names) || isOverCharLimit(names);
    }

    private static boolean isOverCharLimit(String[] names){
        for(String name : names){
            if(name.length() > CHAR_LIMIT){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotEnoughNames(String[] names){

        return names.length < MIN_NUMBER_OF_NAMES;
    }
}