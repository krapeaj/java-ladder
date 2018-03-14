package ladder.domain;

import ladder.view.Output;

import java.util.ArrayList;

public class LadderGame {
    LadderDTO dto = new LadderDTO();

    public LadderGame(String names, int ladderHeight) {
        String[] playerNames = names.split(",");
        ArrayList<Row> ladder = new ArrayList<>();

        dto.setPlayerNames(playerNames);

        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(playerNames.length);
            ladder.add(row);
        }
        dto.setLadder(ladder);
    }

    public String buildLadder() {
        return LadderBuilder.buildLadderString(dto);
    }

    public void displayLadder(String ladderString) {
        Output.printLadder(ladderString);
    }
}