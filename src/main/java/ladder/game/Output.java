package ladder.game;

public class Output {
    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printLadderFrame(){
        System.out.print("|");
    }

    public static void printLadderStep(){
        System.out.print("-");
    }

    public static void printEmptyString(){
        System.out.print(" ");
    }

    public static void printNewLine(){
        System.out.println("");
    }
}

