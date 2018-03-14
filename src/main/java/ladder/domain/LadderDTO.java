package ladder.domain;

import java.util.ArrayList;

public class LadderDTO {
    private String[] playerNames;
    private ArrayList<Row> ladder = new ArrayList<>();
    private StringBuilder builder;
    private int maxNameLength;

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public void setLadder(ArrayList<Row> ladder) {
        this.ladder = ladder;
    }

    public ArrayList<Row> getLadder() {
        return ladder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public void setMaxNameLength(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }
}
