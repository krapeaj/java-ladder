package ladder.game;

public class LadderGameMain {
    public static void main(String[] args){
        Output.printMessage("참여할 사람은 몇 명 인가요?");
        int numberOfPeople = Input.takeInt();
        Output.printMessage("최대 사다리 높이는 몇 개 인가요?");
        int ladderLength = Input.takeInt();

        Ladder lad = new Ladder(ladderLength,numberOfPeople);

        lad.assignRowsToLadder();

        lad.printLadder();

        //lad.testPrintBooleans();
    }
}
