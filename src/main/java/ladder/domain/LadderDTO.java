package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderDTO {
    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();
    private List<Row> ladder = new ArrayList<>();
    private StringBuilder builder;
    private int maxNameLength;


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setLadder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public List<Row> getLadder() {
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
