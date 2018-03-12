package ladder.game;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Row> ladder = new ArrayList<>();

    Ladder(int ladderHeight, int numberOfPeople) {
        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(numberOfPeople);
            this.ladder.add(row);
        }
    }

    private String buildLadderString() {
        StringBuilder builder = new StringBuilder();
        for (Row row : this.ladder) {
            row.returnRowWithRandomBooleans(builder);
            builder.append("|");
            builder.append("\n");
        }
        return builder.toString();
    }

    public String returnLadderString() {
        return buildLadderString();
    }
}