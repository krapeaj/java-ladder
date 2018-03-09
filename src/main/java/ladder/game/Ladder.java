package ladder.game;

import java.util.Random;

public class Ladder {

    private boolean[][] ladder;

    Ladder(int ladderLength, int numberOfPeople) {
        this.ladder = new boolean[ladderLength][numberOfPeople - 1];
    }

    private boolean[] createRowWithRandomBooleans() {
        boolean[] row = new boolean[this.ladder[0].length];
        Random random = new Random();

        for (int i = 0; i < this.ladder[0].length; i++) {
            row[i] = random.nextBoolean();
        }
        return row;
    }

    public void assignRowsToLadder() {
        for (int i = 0; i < this.ladder.length; i++) {
            this.ladder[i] = createRowWithRandomBooleans();
        }
    }

    private String returnLadderFrame() {
        return "|";
    }

    private String returnLadderStep() {
        return "-";
    }

    private String returnEmptyString() {
        return " ";
    }

    private String returnNewLine() {
        return "\n";
    }

    private void addStepString(boolean bool, StringBuilder builder) {
        if (bool) {
            builder.append(returnLadderFrame());
            builder.append(returnLadderStep());
        }
    }

    private void addEmptyString(boolean bool, StringBuilder builder) {
        if (!bool) {
            builder.append(returnLadderFrame());
            builder.append(returnEmptyString());
        }
    }

    private void buildRowString(boolean[] row, StringBuilder builder) {
        for (boolean bool : row) {
            addStepString(bool, builder);
            addEmptyString(bool, builder);
        }
        builder.append(returnLadderFrame());
    }

    private String buildLadderString() {
        StringBuilder builder = new StringBuilder();
        for (boolean[] row : this.ladder) {
            buildRowString(row, builder);
            builder.append(returnNewLine());
        }
        return builder.toString();
    }

    public String returnLadderString() {
        return buildLadderString();
    }
}