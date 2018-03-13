package ladder.domain;

import java.util.ArrayList;

public class LadderBuilder {
    private String[] playerNames;
    private int maxNameLength;
    private static StringBuilder builder = new StringBuilder();

    LadderBuilder(String[] playerNames) {
        this.playerNames = playerNames;
        this.maxNameLength = GameUtils.findMaxNameLength(playerNames);
    }

    private StringBuilder appendStepOrSpace(Row row, int booleanPosition) {
        if (row.isStep(booleanPosition)) {
            //최고 이름 길이에 맞게 "-" 더하기
            LadderFormat.formatStepString(builder, maxNameLength);
            return builder;
        }
        //최고 이름 길이에 맞게 " " 더하기
        LadderFormat.formatSpaceString(builder, maxNameLength);
        return builder;
    }

    private StringBuilder determineLadderPart(Row row, int printCount) {
        int booleanPosition = (printCount - 1) / 2;
        if (printCount % 2 == 0) {
            builder.append("|");
            return builder;
        }
        appendStepOrSpace(row, booleanPosition);
        return builder;
    }

    private StringBuilder buildRowString(Row row) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(builder, maxNameLength);
        final int NUMBER_OF_PRINTS = 2 * this.playerNames.length - 1;

        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(row, printCount);
        }
        return builder;
    }

    private StringBuilder addRowsToString(ArrayList<Row> ladder) {
        for (Row row : ladder) {
            buildRowString(row);
            builder.append("\n"); // 새로운 행
        }
        return builder;
    }

    private StringBuilder addNamesToString() {
        for (String name : this.playerNames) {
            builder.append(LadderFormat.formatNameString(name, maxNameLength));
        }
        return builder;
    }

    public String buildLadderString(ArrayList<Row> ladder) {
        //이름을 먼저 builder 에 더하기
        addNamesToString();

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToString(ladder);

        return builder.toString();
    }
}