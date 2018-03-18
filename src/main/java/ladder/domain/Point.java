package ladder.domain;

import java.util.List;

public class Point {
    private Direction direction;

    Point(List<Boolean> rowOfSteps, int playerIndex) {
        this.direction = Direction.newInstance(rowOfSteps, playerIndex);
    }

    public String giveDirection() {
        if (direction.isLeft()) {
            return "left";
        }
        if (direction.isRight()) {
            return "right";
        }
        return "down";
    }
}