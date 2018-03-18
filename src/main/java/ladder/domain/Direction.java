package ladder.domain;

import java.util.List;

public class Direction {
    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction newInstance(List<Boolean> rowOfSteps, int playerIndex) {
        if (playerIndex == 0) {
            return moveRightOrDown(rowOfSteps.get(playerIndex)); //on left boundary
        }
        if (playerIndex == rowOfSteps.size()) {
            return moveLeftOrDown(rowOfSteps.get(playerIndex - 1)); //on right boundary
        }
        if (rowOfSteps.get(playerIndex)) {
            return new Direction(false, true);
        }
        if (rowOfSteps.get(playerIndex - 1)) {
            return new Direction(true, false);
        }
        return new Direction(false, false);
    }

    private static Direction moveRightOrDown(boolean step) {
        if (step) {
            return new Direction(false, true);
        }
        return new Direction(false, false);
    }

    private static Direction moveLeftOrDown(boolean prevStep) {
        if (prevStep) {
            return new Direction(true, false);
        }
        return new Direction(false, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}