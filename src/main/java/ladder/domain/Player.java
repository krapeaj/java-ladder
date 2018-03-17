package ladder.domain;

public class Player implements Item {
    private String playerName;
    private int position;

    Player(String playerName, int initPosition) {
        this.playerName = playerName;
        this.position = initPosition;
    }

    public int changePosition(String direction) {
        if (direction.equals("right")) {
            return this.position++;
        }
        if (direction.equals("left")) {
            return this.position--;
        }
        return this.position;
    }

    public String getName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }
}