package ladder.game;

import java.util.Random;

public class Ladder {

    private int rowSize;
    private int numberOfRows;
    private boolean[][] ladder;

    Ladder(int ladderLength, int numberOfPeople) {
        this.numberOfRows = ladderLength;
        this.rowSize = numberOfPeople - 1;
        this.ladder = new boolean[ladderLength][numberOfPeople - 1];
    }

    private boolean[] createRowWithRandomBooleans() {
        boolean[] row = new boolean[this.rowSize];
        Random random = new Random();

        for (int i = 0; i < this.rowSize; i++) {
            row[i] = random.nextBoolean();
        }
        return row;
    }

    public void assignRowsToLadder(){
        for(int i = 0; i < numberOfRows; i++){
            this.ladder[i] = createRowWithRandomBooleans();
        }
    }

    private void convertBooleanToLadderParts(boolean bool){
        if(bool){
            Output.printLadderFrame();
            Output.printLadderStep();
        }
        Output.printLadderFrame();
        Output.printEmptyString();
    }

    private void printLadderRow(boolean[] row){
        for(boolean bool : row) {
            convertBooleanToLadderParts(bool);
        }
    }

    public void printLadder(){
        for(boolean[] row : this.ladder){
            printLadderRow(row);
            Output.printLadderFrame();
            Output.printNewLine();
        }
    }
}
//    public void testPrintBooleans(){
//        for(boolean[] row : this.ladder){
//            for(boolean bool : row){
//
//                Output.printLadderFrame();
//                System.out.print(bool);
//            }
//            Output.printLadderFrame();
//            Output.printNewLine();
//        }
//    }