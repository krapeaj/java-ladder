package ladder.domain;

public class Player implements Item {
    private String playerName;
    private int position;

    Player(String playerName, int initPosition) {
        this.playerName = playerName;
        this.position = initPosition;
    }

    public int increasePosition() {
        return this.position++;
    }

    public int decreasePosition() {
        return this.position--;
    }

    public String getName() {
        return playerName;
    }

    public int getInitPosition() {
        return position;
    }
}
