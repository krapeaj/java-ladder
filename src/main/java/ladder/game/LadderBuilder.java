package ladder.game;

import java.util.ArrayList;

public class LadderBuilder {

    public String buildLadderString(ArrayList<Row> ladder, String[] playerNames) {
        StringBuilder builder = new StringBuilder();
        //최대 이름 길이 구하기
        int maxNameLength = findMaxNameLength(playerNames);

        //이름을 먼저 출력
        for (String name : playerNames) {
            builder.append(LadderFormat.formatNameString(name, maxNameLength));
        }
        builder.append("\n");

        //행(row)을 출력
        for (Row row : ladder) {
            buildRowWithRandomBooleans(row, maxNameLength, builder);

            builder.append("|");
            builder.append("\n");
        }
        return builder.toString();
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

    private void buildRowWithRandomBooleans(Row row, int maxNameLength, StringBuilder builder) {
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