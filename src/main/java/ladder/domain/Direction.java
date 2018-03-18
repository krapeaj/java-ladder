package ladder.domain;

import java.util.List;

public class Direction {
    private String dir;

    private Direction(String dir) {
        this.dir = dir;
    }

    public static Direction newInstance(List<Boolean> rowOfSteps, int playerIndex) {
        if (playerIndex == 0) {
            return moveRightOrDown(rowOfSteps.get(playerIndex)); //on left boundary
        }
        if (playerIndex == rowOfSteps.size()) {
            return moveLeftOrDown(rowOfSteps.get(playerIndex - 1)); //on right boundary
        }
        if (rowOfSteps.get(playerIndex)) {
            return new Direction("right");
        }
        if (rowOfSteps.get(playerIndex - 1)) {
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