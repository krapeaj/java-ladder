package ladder.domain;

import ladder.view.Output;

import java.util.ArrayList;

public class LadderGame {
    private ArrayList<Row> ladder = new ArrayList<>();
    private String[] playerNames;

    public LadderGame(String names, int ladderHeight) {
        this.playerNames = names.split(",");

        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(playerNames.length);
            ladder.add(row);
        }
    }

    public String buildLadder() {
        return LadderBuilder.buildLadderString(ladder, playerNames);
    }

    public void displayLadder(String ladderString) {
        Output.print(ladderString);
    }
}