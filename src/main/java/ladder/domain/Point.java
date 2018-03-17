package ladder.domain;

public class Point {
    private Direction direction;

    Point(boolean step) {
        this.direction = Direction.newInstance(step);
    }

    public String toDirection() {
        if (direction.isLeft()) { //isLeft()
            return "left";
        }
        if (direction.isRight()) { //isRight()
            return "right";
        }
        return "down"; //isDown()
    }
}