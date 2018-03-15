package ladder.domain;

public class LadderFormat {

    public static String formatName(LadderDTO dto, String name) {
        for (int i = 0; i < dto.getMaxNameLength() - name.length() + 1; i++) {
            dto.getBuilder().append(" ");
        }
        return dto.getBuilder().toString();
    }

    public static String formatRow(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();
        for (int i = 0; i < dto.getMaxNameLength(); i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static String formatStepString(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();
        for (int i = 0; i < dto.getMaxNameLength(); i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static String formatSpaceString(LadderDTO dto) {
        StringBuilder builder = dto.getBuilder();
        for (int i = 0; i < dto.getMaxNameLength(); i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}