package ladder.domain;

import java.util.ArrayList;

public class LadderBuilder {

    private static StringBuilder builder = new StringBuilder();

    private static StringBuilder appendStepOrSpace(Row row, int maxNameLength, int booleanPosition) {
        if (row.isStep(booleanPosition)) {
            //최고 이름 길이에 맞게 "-" 더하기
            LadderFormat.formatStepString(builder, maxNameLength);
            return builder;
        }
        //최고 이름 길이에 맞게 " " 더하기
        LadderFormat.formatSpaceString(builder, maxNameLength);
        return builder;
    }

    private static StringBuilder determineLadderPart(Row row, int maxNameLength, int printCount) {
        int booleanPosition = (printCount - 1) / 2;
        if (printCount % 2 == 0) {
            builder.append("|");
            return builder;
        }
        appendStepOrSpace(row, maxNameLength, booleanPosition);
        return builder;
    }

    private static StringBuilder buildRowString(Row row, String[] playerNames, int maxNameLength) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(builder, maxNameLength);

        //append ladder parts to string
        final int NUMBER_OF_PRINTS = 2 * playerNames.length - 1;
        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(row, maxNameLength, printCount);
        }
        return builder;
    }

    static StringBuilder addRowsToString(ArrayList<Row> ladder, String[] playerNames, int maxNameLength) {
        for (Row row : ladder) {
            buildRowString(row, playerNames, maxNameLength);
            builder.append("\n"); // 새로운 행
        }
        return builder;
    }

    static StringBuilder addNamesToString(String[] playerNames, int maxNameLength) {

        for (String name : playerNames) {
            builder.append(LadderFormat.formatNameString(name, maxNameLength));
        }
        return builder;
    }

    static String buildLadderString(ArrayList<Row> ladder, String[] playerNames) {
        //find longest name length
        int maxNameLength = GameUtils.findMaxNameLength(playerNames);

        //이름을 먼저 builder 에 더하기
        addNamesToString(playerNames, maxNameLength);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToString(ladder, playerNames, maxNameLength);

        return builder.toString();
    }
}