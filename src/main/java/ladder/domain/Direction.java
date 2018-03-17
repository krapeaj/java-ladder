package ladder.domain;

import java.util.List;

public class Direction {
    private String dir;
    //private static String prevDir;

    private Direction(String dir) {
        this.dir = dir;
    }

    public static Direction newInstance(List<Boolean> rowOfSteps, int index) {
        if (index == 0) {
            return moveRightOrDown(rowOfSteps.get(index)); //on left boundary
        }
        if (index == rowOfSteps.size()) {
            return moveLeftOrDown(rowOfSteps.get(index - 1)); //on right boundary
        }
        if (rowOfSteps.get(index)) {
            return new Direction("right");
        }
        if (rowOfSteps.get(index - 1)) {
            return new Direction("left");
        }
        return new Direction("down");
    }

    private static Direction moveRightOrDown(boolean step) {
        if (step) {
            return new Direction("right");
        }
        return new Direction("down");
    }

    private static Direction moveLeftOrDown(boolean prevStep) {
        if (prevStep) {
            return new Direction("left");
        }
        return new Direction("down");
    }

    public boolean isLeft() {
        return dir.equals("left");
    }

    public boolean isRight() {
        return dir.equals("right");
    }
}