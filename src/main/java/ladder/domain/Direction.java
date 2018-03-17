package ladder.domain;

public class Direction {
    private String dir;
    private static String prevDir;

    private Direction(String dir) {
        this.dir = dir;
    }

    public static Direction newInstance(boolean step) {
        if(step){
            prevDir = "right";
            return new Direction("right");
        }
        if(prevDir.equals("right")){
            prevDir = "left";
            return new Direction("left");
        }
        prevDir = "down";
        return new Direction("down");
    }

    public boolean isLeft() {
        return dir.equals("left");
    }

    public boolean isRight() {
        return dir.equals("right");
    }
}