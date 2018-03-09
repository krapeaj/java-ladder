package ladder.game;

public class Output {
    public static void print(String message) {
        System.out.println(message);
    }

    public static String returnLadderFrame() {
        return "|";
    }

    public static String returnLadderStep() {
        return "-";
    }

    public static String returnEmptyString() {
        return " ";
    }

    public static String returnNewLine() {
        return "\n";
    }
}