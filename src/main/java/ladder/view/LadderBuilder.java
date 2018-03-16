package ladder.view;

import ladder.domain.*;

import java.util.List;

public class LadderBuilder {

    private String appendStepOrSpace(Row row, int col, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        String spaces;
        if (row.isStep(col)) {
            //최고 이름 길이에 맞게 "-" 더하기
            spaces = GameUtils.formatStepString(maxNameLength);
            return builder.append(spaces).toString();
        }
        //최고 이름 길이에 맞게 " " 더하기
        spaces = GameUtils.formatSpaceString(maxNameLength);
        return builder.append(spaces).toString();
    }

    private String createLadderPart(Row row, int col, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        if (col % 2 == 0) {
            return builder.append("|").toString();
        }
        String stepOrSpace = appendStepOrSpace(row, col, maxNameLength);
        return builder.append(stepOrSpace).toString();
    }

    private String buildRow(Row row, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        //add a space before each row for as many times as the max name length
        String spaces = GameUtils.formatRow(maxNameLength);
        builder.append(spaces);
        //append ladder parts to string
        for (int col = 0; col < row.getRowLength(); col++) {
            String ladderPart = createLadderPart(row, col, maxNameLength);
            builder.append(ladderPart);
        }
        return builder.toString();
    }

    private String createRows(List<Row> ladder, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        for (Row row : ladder) {
            String rowLine = buildRow(row, maxNameLength);
            builder.append(rowLine);
            builder.append("\n"); // 새로운 행
        }
        return builder.toString();
    }

    <T extends Item> String createLineOfUserInput(List<T> items, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        for (T item : items) {
            String spaces = GameUtils.formatName(item, maxNameLength);
            builder.append(spaces);
            builder.append(item.getName());
        }
        builder.append("\n");
        return builder.toString();
    }

    public String buildLadder(List<Row> ladder, List<Player> players, List<Prize> prizes) {
        StringBuilder builder = new StringBuilder();
        int maxNameLength = GameUtils.findMaxNameLength(players, prizes);

        //이름을 먼저 builder 에 더하기
        String startLine = createLineOfUserInput(players, maxNameLength);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        String rowLines = createRows(ladder, maxNameLength);

        //새로운 행
        String endLine = createLineOfUserInput(prizes, maxNameLength);

        builder.append(startLine);
        builder.append(rowLines);
        builder.append(endLine);

        return builder.toString();
    }
}