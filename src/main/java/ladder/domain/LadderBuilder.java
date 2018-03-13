package ladder.domain;

import java.util.ArrayList;

public class LadderBuilder {
    private int maxNameLength;
    private static StringBuilder builder = new StringBuilder();

    LadderBuilder(String[] playerNames) {
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

    private StringBuilder buildRowString(Row row, String[] playerNames) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(builder, maxNameLength);
        final int NUMBER_OF_PRINTS = 2 * playerNames.length - 1;

        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(row, printCount);
        }
        return builder;
    }

    private StringBuilder addRowsToString(ArrayList<Row> ladder, String[] playerNames) {
        for (Row row : ladder) {
            buildRowString(row, playerNames);
            builder.append("\n"); // 새로운 행
        }
        return builder;
    }

    StringBuilder addNamesToString(String[] playerNames) {
        for (String name : playerNames) {
            builder.append(LadderFormat.formatNameString(name, maxNameLength));
        }
        return builder;
    }

    String buildLadderString(ArrayList<Row> ladder, String[] playerNames) {
        //이름을 먼저 builder 에 더하기
        addNamesToString(playerNames);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToString(ladder, playerNames);

        return builder.toString();
    }
}