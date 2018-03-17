package ladder.domain;

import java.util.Random;

public class Direction {
    private String dir;
    private static String prevDir;

    private Direction(String dir) {
        this.dir = dir;
    }

    public static Direction newInstance() {
        Random random = new Random();

        if (prevDirIsRight()) {
            return new Direction(goRightOrDown());
        }
        boolean goLeft = random.nextBoolean();
        if (goLeft) {
            prevDir = "left";
            return new Direction("left");
        }
        prevDir = "right";
        return new Direction("right");
    }

    private static boolean prevDirIsRight() {
        return prevDir.equals("right");
    }

    public static String goRightOrDown() {
        Random random = new Random();
        boolean goRight = random.nextBoolean();
        if (goRight) {
            return "right";
        }
        return "";
    }

    public boolean isLeft() {
        return dir.equals("left");
    }

    public boolean isRight() {
        return dir.equals("right");
    }
}