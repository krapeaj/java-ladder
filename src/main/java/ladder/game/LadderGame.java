package ladder.game;

import java.util.ArrayList;

public class LadderGame {
    private ArrayList<Row> ladder = new ArrayList<>();
    private String[] playerNames;

    LadderGame(String names, int ladderHeight) {
        this.playerNames = names.split(",");

        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(playerNames.length);
            this.ladder.add(row);
        }
    }

    public String buildLadder() {
        LadderBuilder ladderBuilder = new LadderBuilder(this.playerNames);
        return ladderBuilder.buildLadderString(this.ladder);
    }

    public void displayLadder(String ladderString) {
        Output.print(ladderString);
    }
}