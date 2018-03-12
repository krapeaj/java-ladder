package ladder.game;

import java.util.ArrayList;

public class LadderBuilder {
    private String[] playerNames;
    private int maxNameLength;

    LadderBuilder(String[] playerNames) {
        this.playerNames = playerNames;
        this.maxNameLength = GameUtils.findMaxNameLength(playerNames);
    }

    private StringBuilder appendStepOrSpace(Row row, StringBuilder builder, int booleanPosition) {
        if (row.isStep(booleanPosition)) {
            //최고 이름 길이에 맞게 "-" 더하기
            LadderFormat.formatStepString(builder, this.maxNameLength);
            return builder;
        }
        //최고 이름 길이에 맞게 " " 더하기
        LadderFormat.formatSpaceString(builder, this.maxNameLength);
        return builder;
    }

    private StringBuilder determineLadderPart(StringBuilder builder, Row row, int printCount) {
        int booleanPosition = (printCount - 1) / 2;
        if (printCount % 2 == 0) {
            builder.append("|");
            return builder;
        }
        appendStepOrSpace(row, builder, booleanPosition);
        return builder;
    }

    private StringBuilder buildRowString(StringBuilder builder, Row row) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(builder, this.maxNameLength);
        final int NUMBER_OF_PRINTS = 2 * this.playerNames.length - 1;
        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(builder, row, printCount);
        }
        return builder;
    }

    private StringBuilder addRowsToString(StringBuilder builder, ArrayList<Row> ladder) {
        for (Row row : ladder) {
            buildRowString(builder, row);
            builder.append("\n"); // 새로운 행
        }
        return builder;
    }

    private StringBuilder addNamesToString(StringBuilder builder) {
        for (String name : this.playerNames) {
            builder.append(LadderFormat.formatNameString(name, this.maxNameLength));
        }
        return builder;
    }

    public String buildLadderString(ArrayList<Row> ladder) {
        StringBuilder builder = new StringBuilder();

        //이름을 먼저 builder 에 더하기
        addNamesToString(builder);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToString(builder, ladder);

        return builder.toString();
    }
}