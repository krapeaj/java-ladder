package ladder.domain;

public class Point {
    private int position;
    private Direction direction;

    Point(int position, int rowLegth) {
        String onEdge = "";
        if(position == 0){
            onEdge = "left";
        }
        if(position == rowLegth){
            onEdge = "right";
        }
        this.position = position;
        this.direction = Direction.newInstance(onEdge);
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