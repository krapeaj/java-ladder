package ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final int CHAR_LIMIT = 5;
    private static final int MIN_NUMBER_OF_NAMES = 2;
    private static final int MIN_HEIGHT = 2;

    public static String promptUserForNames() {
        System.out.println("참여할 사람 이름을 쉼표(,)를 기준으로 입력하세요:");
        String names = Input.takeString();

        return checkNamesValidity(names);
    }

    private static String takeString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private static String checkNamesValidity(String names){
        String[] splitNames = names.split(",");
        if(isNotEnoughNames(splitNames)){
            System.out.print("최소 두명의 이름을 입력해주세요. ");
            return promptUserForNames();
        }
        if(isOverCharLimit(splitNames)){
            System.out.print("이름은 다섯 자 이하만 입력 가능합니다. ");
            return promptUserForNames();
        }
        return names;
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

    public static int promptUserForLadderHeight() {
        Output.print("최대 사다리 높이는 몇 개 인가요?");
        return Input.checkHeightValidity(Input.takeInt());
    }

    private static int takeInt() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("숫자를 입력해주세요.");
            return takeInt();
        }
    }

    private static int checkHeightValidity(int userInput) {
        if(userInput <= MIN_HEIGHT){
            System.out.println("2보다 큰 숫자를 입력해주세요.");
            return promptUserForLadderHeight();
        }
        return userInput;
    }
}