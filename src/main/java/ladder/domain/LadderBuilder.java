package ladder.domain;

public class LadderBuilder {

    private static String appendStepOrSpace(LadderDTO dto, Row row, int boolPosition) {
        StringBuilder builder = dto.getBuilder();
        if (row.isStep(boolPosition)) {
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
        int boolPosition = (printCount - 1) / 2;
        if (printCount % 2 == 0) {
            builder.append("|");
            return builder.toString();
        }
        appendStepOrSpace(dto, row, boolPosition);
        return builder.toString();
    }

    private static String buildRow(LadderDTO dto, Row row) {
        //add a space before each row for as many times as the max name length
        LadderFormat.formatRow(dto);

        //append ladder parts to string
        final int NUMBER_OF_PRINTS = 2 * dto.getPlayerNames().length - 1;
        for (int printCount = 0; printCount < NUMBER_OF_PRINTS; printCount++) {
            determineLadderPart(dto, row, printCount);
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
            LadderFormat.formatName(dto, name);
            builder.append(name);
        }
        return builder.toString();
    }

    static String buildLadder(LadderDTO dto) {
        GameUtils.findMaxNameLength(dto);
        dto.setBuilder(new StringBuilder());

        //이름을 먼저 builder 에 더하기
        addNamesToBuilder(dto);

        //새로운 행
        dto.getBuilder().append("\n");

        //각 행(row)을 builder 에 더하기
        addRowsToBuilder(dto);

        return dto.getBuilder().toString();
    }
}