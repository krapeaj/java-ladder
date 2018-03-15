package ladder.domain;

public class Player {
    private String name;
    private int initPosition;

    Player(String name, int initPosition) {
        this.name = name;
        this.initPosition = initPosition;
    }

    public String getName() {
        return name;
    }

    public int getInitPosition() {
        return initPosition;
    }
}
