package ladder.domain;

import java.util.List;

public class Point {
    private final int index;
    private final Direction direction;

    Point(List<Boolean> rowOfSteps, int playerIndex) {
        this.index = playerIndex;
        this.direction = Direction.newInstance(rowOfSteps, playerIndex);
    }

    public int assignNextIndex() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }
}