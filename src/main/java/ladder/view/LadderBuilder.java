package ladder.view;

import ladder.domain.GameUtils;
import ladder.domain.LadderDTO;
import ladder.domain.Row;

public class LadderBuilder {

    private static String appendStepOrSpace(LadderDTO dto, Row row, int col) {
        StringBuilder builder = dto.getBuilder();
        if (row.isStep(col)) {
            //최고 이름 길이에 맞게 "-" 더하기
            GameUtils.formatStepString(dto);
            return builder.toString();
        }
        //최고 이름 길이에 맞게 " " 더하기
        GameUtils.formatSpaceString(dto);
        return builder.toString();
    }

    private static String determineLadderPart(LadderDTO dto, Row row, int col) {
        StringBuilder builder = dto.getBuilder();
        if (col % 2 == 0) {
            builder.append("|");
            return builder.toString();
        }
        appendStepOrSpace(dto, row, col);
        return builder.toString();
    }

    private static String buildRow(LadderDTO dto, Row row) {
        //add a space before each row for as many times as the max name length
        GameUtils.formatRow(dto);
        final int rowLength = 2 * dto.getPlayerNames().length - 1;
        //append ladder parts to string
        for (int col = 0; col < rowLength; col++) {
            determineLadderPart(dto, row, col);
        }
        return dto.getBuilder().toString();
    }

    private static String addRowsToBuilder(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();
        for (Row row : dto.getLadder()) {
            buildRow(dto, row);
            builder.append("\n"); // 새로운 행
        }
        return builder.toString();
    }

    static String addNamesToBuilder(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();

        for (String name : dto.getPlayerNames()) {
            GameUtils.formatName(dto, name);
            builder.append(name);
        }
        return builder.toString();
    }

    public static LadderDTO buildLadder(LadderDTO dto) {
        GameUtils.findMaxNameLength(dto);
        dto.setBuilder(new StringBuilder());

        //이름을 먼저 builder 에 더하기
        addNamesToBuilder(dto);

        //새로운 행
        dto.getBuilder().append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToBuilder(dto);

        return dto;
    }
}