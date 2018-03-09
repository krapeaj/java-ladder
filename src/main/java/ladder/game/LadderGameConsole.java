package ladder.game;

public class LadderGameConsole {
    public static void main(String[] args) {
        int numberOfPeople = promptUserForNumberOfPeople();
        int ladderLength = promptUserForLadderLength();

        Ladder ladder = new Ladder(ladderLength, numberOfPeople);

        printLadderString(ladder);
    }

    private static int promptUserForNumberOfPeople() {
        Output.print("참여할 사람은 몇 명 인가요?");
        return Input.takeInt();
    }

    private static int promptUserForLadderLength() {
        Output.print("최대 사다리 높이는 몇 개 인가요?");
        return Input.takeInt();
    }

    private static void printLadderString(Ladder ladder) {
        Output.print(ladder.returnLadderString());
    }
}