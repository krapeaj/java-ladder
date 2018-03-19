package ladder.domain;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction goDown() {
        return new Direction(false, false);
    }

    public static Direction toTheLeft() {
        return new Direction(true, false);
    }

    public static Direction toTheRight() {
        return new Direction(false, true);

    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}