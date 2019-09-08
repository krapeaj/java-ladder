package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.UserPrompt;

import java.util.Map;

public class Output {

    public static void askForPlayerNames() {
        System.out.println("Enter the names of the participants, separated by (','):");
    }

    public static void askForPrizes() {
        System.out.println("Enter prizes:");
    }

    public static void askForLadderHeight() {
        System.out.println("Enter ladder height:");
    }

    public static void printNotEnoughNames() {
        System.out.print("Needs at least 2 names.");
    }

    public static void printNotEqualNumbers() {
        System.out.print("The number of names must equal the number of prizes");
    }

    public static void printOverMaxChars() {
        System.out.print("A name must be less than 5 characters.");
    }

    public static void printUnderMinHeight() {
        System.out.print("Needs height of at least 2.");
    }

    public static void printLadder(LadderGame game) {
        String ladder = game.startConversion();
        System.out.println(ladder);
    }

    public static void askForResultName() {
        System.out.println("Enter the name of a participant to see his/her result ('all' if want to see all):");
    }

    public static void printMoreThanOneName() {
        System.out.println("Enter only one name.");
    }

    public static void printNameDoesNotExist(String name) {
        System.out.println(name + " is not in this game.");
    }

    public static void printSelectedResult(Map<String, String> result, String name) {
        if (!UserPrompt.isExit(name)){
            System.out.println(name + ": " + result.get(name));
        }
    }

    public static void printAllResult(Map<String, String> result) {
        for (Map.Entry<String, String> set : result.entrySet()) {
            System.out.println(set.getKey() + ": " + set.getValue());
        }
    }
}