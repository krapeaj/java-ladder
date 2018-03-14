package ladder.domain;

public class LadderBuilder {

    private static String appendStepOrSpace(LadderDTO dto, Row row, int booleanPosition) {
        StringBuilder builder = dto.getBuilder();
        if (row.isStep(booleanPosition)) {
            //최고 이름 길이에 맞게 "-" 더하기
            LadderFormat.formatStepString(dto);
            return builder.toString();
        }
        //최고 이름 길이에 맞게 " " 더하기
        LadderFormat.formatSpaceString(dto);
        return builder.toString();
    }

    private static String determineLadderPart(LadderDTO dto, Row row, int printCount) {
        StringBuilder builder = dto.getBuilder();
        int booleanPosition = (printCount - 1) / 2;
        if (printCount % 2 == 0) {
            builder.append("|");
            return builder.toString();
        }
        appendStepOrSpace(dto, row, booleanPosition);
        return builder.toString();
    }

    private static String buildRowString(LadderDTO dto, Row row) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(dto);

        //append ladder parts to string
        final int NUMBER_OF_PRINTS = 2 * dto.getPlayerNames().length - 1;
        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(dto, row, printCount);
        }
        return dto.getBuilder().toString();
    }

    private static String addRowsToString(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();
        for (Row row : dto.getLadder()) {
            buildRowString(dto, row);
            builder.append("\n"); // 새로운 행
        }
        return builder.toString();
    }

    static String addNamesToString(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();

        for (String name : dto.getPlayerNames()) {
            LadderFormat.formatNameString(dto, name);
            builder.append(name);
        }
        return builder.toString();
    }

    static String buildLadderString(LadderDTO dto) {
        GameUtils.findMaxNameLength(dto);
        dto.setBuilder(new StringBuilder());

        //이름을 먼저 builder 에 더하기
        addNamesToString(dto);

        //새로운 행
        dto.getBuilder().append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToString(dto);

        return dto.getBuilder().toString();
    }
}