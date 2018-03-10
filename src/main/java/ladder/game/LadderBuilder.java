package ladder.game;

import java.util.ArrayList;

public class LadderBuilder {

    public String buildLadderString(ArrayList<Row> ladder, String[] playerNames) {
        StringBuilder builder = new StringBuilder();
        //최대 이름 길이 구하기
        int maxNameLength = findMaxNameLength(playerNames);

        //이름을 먼저 builder 에 더하기
        addNameToStringBuilder(builder, playerNames, maxNameLength);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToStringBuilder(builder, ladder, maxNameLength);

        return builder.toString();
    }

    private StringBuilder addNameToStringBuilder(StringBuilder builder, String[] playerNames, int maxNameLength){
        for (String name : playerNames) {
            builder.append(LadderFormat.formatNameString(name, maxNameLength));
        }
        return builder;
    }

    private StringBuilder addRowsToStringBuilder(StringBuilder builder, ArrayList<Row> ladder, int maxNameLength){
        for (Row row : ladder) {
            buildRowOfRandomBooleans(row, maxNameLength, builder);
            builder.append("|");
            builder.append("\n"); // 새로운 행
        }
        return builder;
    }

    private int findMaxNameLength(String[] playerNames) {
        int currentMax = 0;
        for (String name : playerNames) {
            currentMax = compareLength(name, currentMax);
        }
        return currentMax;
    }

    private int compareLength(String name, int currentMax) {
        if (name.length() > currentMax) {
            currentMax = name.length();
            return currentMax;
        }
        return currentMax;
    }

    private void buildRowOfRandomBooleans(Row row, int maxNameLength, StringBuilder builder) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(builder, maxNameLength);
        for (boolean bool : row.getRowOfRandomBooleans()) {
            addStepString(bool, builder, maxNameLength);
            addEmptyString(bool, builder, maxNameLength);
        }
    }

    private StringBuilder addStepString(Boolean bool, StringBuilder builder, int maxNameLength) {
        if (bool) {
            builder.append("|");
            //format step string so it adapts to max name length
            LadderFormat.formatStepString(builder, maxNameLength);
        }
        return builder;
    }

    private StringBuilder addEmptyString(Boolean bool, StringBuilder builder, int maxNameLength) {
        if (!bool) {
            builder.append("|");
            //format empty string so it adapts to max name length
            LadderFormat.formatEmptyString(builder, maxNameLength);
        }
        return builder;
    }
}