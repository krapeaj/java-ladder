package ladder.view;

import ladder.domain.*;

import static ladder.domain.GameUtils.*;

import java.util.List;

public class LadderBuilder {

    public String buildLadder(List<Row> ladder, List<Player> players, List<Prize> prizes) {
        StringBuilder builder = new StringBuilder();
        int maxNameLength = findMaxNameLength(players, prizes);

        String startLine = createLineOfUserInput(players, maxNameLength); //이름을 먼저 builder 에 더하기

        builder.append("\n"); //새로운 행

        String rowLines = createRows(ladder, maxNameLength); //각 행(row)을 builder 에 더하기

        String endLine = createLineOfUserInput(prizes, maxNameLength); //새로운 행

        builder.append(startLine);
        builder.append(rowLines);
        builder.append(endLine);

        return builder.toString();
    }

    private String createRows(List<Row> ladder, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        for (Row row : ladder) {
            String rowLine = buildRow(row, maxNameLength);
            builder.append(rowLine);
            builder.append("|");
            builder.append("\n"); // 새로운 행
        }
        return builder.toString();
    }

    private String buildRow(Row row, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        String spaces = formatRow(maxNameLength);
        builder.append(spaces); //add a space before each row for as many times as the max name length

        for (int col = 0; col < row.getRowLength(); col++) { //append ladder parts to string
            String ladderPart = createLadderPart(row.isStep(col), maxNameLength);
            builder.append(ladderPart);
        }
        return builder.toString();
    }

    String createLadderPart(boolean isStep, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        if (isStep) {
            return builder.append(formatStep(maxNameLength)).toString(); //최고 이름 길이에 맞게 "-" 더하기
        }
        return builder.append(formatSpace(maxNameLength)).toString(); //최고 이름 길이에 맞게 " " 더하기
    }

    <T extends Item> String createLineOfUserInput(List<T> items, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        for (T item : items) {
            String spaces = formatName(item, maxNameLength);
            builder.append(spaces);
            builder.append(item.getName());
        }
        builder.append("\n");
        return builder.toString();
    }
}