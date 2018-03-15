package ladder.view;

import ladder.domain.GameUtils;
import ladder.domain.Player;
import ladder.domain.Row;

import java.util.List;

public class LadderBuilder {
    private StringBuilder builder = new StringBuilder();

    private String appendStepOrSpace(Row row, int col, int maxNameLength) {
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

    private String determineLadderPart(Row row, int col, int maxNameLength) {
        if (col % 2 == 0) {
            builder.append("|");
            return builder.toString();
        }
        appendStepOrSpace(row, col, maxNameLength);
        return builder.toString();
    }

    private String buildRow(Row row, int maxNameLength) {
        //add a space before each row for as many times as the max name length
        String spaces = GameUtils.formatRow(maxNameLength);
        builder.append(spaces);
        //append ladder parts to string
        for (int col = 0; col < row.getRowLength(); col++) {
            determineLadderPart(row, col, maxNameLength);
        }
        return builder.toString();
    }

    private String addRowsToBuilder(List<Row> ladder, int maxNameLength) {
        ;
        for (Row row : ladder) {
            buildRow(row, maxNameLength);
            builder.append("\n"); // 새로운 행
        }
        return builder.toString();
    }

    String addNamesToBuilder(List<Player> players, int maxNameLength) {
        for (Player player : players) {
            String spaces = GameUtils.formatName(player, maxNameLength);
            builder.append(spaces);
            builder.append(player.getName());
        }
        return builder.toString();
    }

    public String buildLadder(List<Row> ladder, List<Player> players) {
        int maxNameLength = GameUtils.findMaxNameLength(players);

        //이름을 먼저 builder 에 더하기
        addNamesToBuilder(players, maxNameLength);

        //새로운 행
        builder.append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToBuilder(ladder, maxNameLength);

        return builder.toString();
    }
}