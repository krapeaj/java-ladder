package ladder.domain;

public class Player implements Item {
    private String playerName;
    private int initPosition;

    Player(String playerName, int initPosition) {
        this.playerName = playerName;
        this.initPosition = initPosition;
    }

    public String getName(){
        return playerName;
    }

    public int getInitPosition() {
        return initPosition;
    }
}
