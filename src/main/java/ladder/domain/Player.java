package ladder.domain;

public class Player implements Item {
    private String playerName;
    private int position;

    public Player(String playerName, int initPosition) {
        this.playerName = playerName;
        this.position = initPosition;
    }

    public int changePosition(int position) {
        return this.position = position;
    }

    public String getName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }
}