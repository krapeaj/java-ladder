package ladder.domain;

public class Point {
    private int position;
    private Direction direction;

    Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int moveToNewPosition() {
        if (direction.isLeft()) { //isLeft()
            return position++;
        }

        if (direction.isRight()) { //isRight()
            return position--;
        }
        //isDown()
        return position;
    }
}