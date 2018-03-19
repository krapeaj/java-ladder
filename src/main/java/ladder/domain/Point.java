package ladder.domain;

import java.util.List;

public class Point {
    private final int index;
    private final Direction direction;

    Point(List<Boolean> rowOfSteps, int playerIndex) {
        this.index = playerIndex;
        Direction dir;

        if(stepIsOnTheLeft(rowOfSteps)){ //왼쪽에 스탭이 있는지
            dir = Direction.toTheLeft();
        }
        else if(stepIsOnTheRight(rowOfSteps)){ //오른쪽에 스탭이 있는지
            dir = Direction.toTheRight();
        }
        else {
            dir = Direction.goDown();
        }
        this.direction = dir;
    }

    private boolean isLeftEnd() {
        return index == 0;
    }

    private boolean isRightEnd(List<Boolean> rowOfSteps) {
        return index == rowOfSteps.size();
    }

    boolean stepIsOnTheLeft(List<Boolean> rowOfSteps) {
        if(isLeftEnd()){
            return false;
        }
        return rowOfSteps.get(index - 1);
    }

    boolean stepIsOnTheRight(List<Boolean> rowOfSteps) {
        if(isRightEnd(rowOfSteps)){
            return false;
        }
        return rowOfSteps.get(index);
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