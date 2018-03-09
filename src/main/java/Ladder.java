

import java.util.List;
import java.util.Random;

public class Ladder {

    private int rowSize;
    private int numberOfRows;
    private boolean[][] ladder;

    public Ladder(int ladderLength, int numberOfPeople) {
        this.numberOfRows = ladderLength;
        this.rowSize = 2 * numberOfPeople - 1;
        this.ladder = new boolean[ladderLength][numberOfPeople];
    }

    public boolean[] createLadderFrame() {
        boolean[] row = new boolean[rowSize];
        for (int i = 0; i < rowSize; i++) {
            if (i % 2 == 0) {

            }
        }

    }

    public boolean[] assignRandomBoolean(int rowSize) {
        boolean[] row = new boolean[rowSize];
        Random random = new Random();
        for (int i = 0; i < rowSize; i++) {
            if (i % 2 == 0) { // 홀수 인덱스 일때
                continue;
            } else if (i % 2 != 0 && random.nextBoolean()) { // 짝수 인덱스이고 랜덤 불리언이 true 일때
                row[i] = true;
            } else {
                row[i] = false;
            }
        }
        return row;
    }


    public void createLadder() {
        for (int i = 0; i < this.numberOfRows; i++) {
            this.ladder[i] = assignRandomBoolean(this.rowSize);
        }
    }

    public Boolean[] returnRow(int rowNumber) {
        return this.ladder[rowNumber];
    }

    public void printFigure(Boolean bool) {
        if (bool == null) {
            System.out.print("|");
        } else if (bool == true) {
            System.out.print("-");
        } else if (bool == false) {
            System.out.print(" ");
        }
    }

    public void printLadder() {
        for (boolean[] x : ladder) {
            Boolean[] row = returnRow(rowNumber);

            printFigure(row[rowNumber]);
        }
    }

//    public static void printLadder(Ladder lad){
//        for(String[] x : lad.ladder){
//            System.out.println("");
//            for(String y : x){
//                System.out.print(y);
//            }
//        }
//    }
}
