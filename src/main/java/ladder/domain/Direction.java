package ladder.domain;

import java.util.Random;

public class Direction {
    private String dir;
    private static String prevDir;

    private Direction(String dir) {
        this.dir = dir;
    }

    public static Direction newInstance(String onEdge) {
        Random random = new Random();

        if (onEdge.equals("left")){
            return new Direction(goLeftOrDown());
        }
        if (onEdge.equals("right") || prevDirIsRight()) {
            return new Direction(goRightOrDown());
        }
        if (random.nextBoolean()) {
            prevDir = "left";
            return new Direction("left");
        }
        prevDir = "right";
        return new Direction("right");
    }


    private static boolean prevDirIsRight() {
        return prevDir.equals("right");
    }

    private static String goRightOrDown() {
        Random random = new Random();
        boolean goRight = random.nextBoolean();
        if (goRight) {
            prevDir = "right";
            return "right";
        }
        prevDir = "";
        return "";
    }

    private static String goLeftOrDown() {
        Random random = new Random();
        boolean goLeft = random.nextBoolean();
        if (goLeft) {
            prevDir = "left";
            return "left";
        }
        prevDir = "";
        return "";
    }

    public boolean isLeft() {
        return dir.equals("left");
    }

    public boolean isRight() {
        return dir.equals("right");
    }
}