package ladder.domain;

public class LadderFormat {
    private static int maxNameLength;

    LadderFormat(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    static String formatNameString(String name) {
        StringBuilder formattedName = new StringBuilder();

        for (int i = 0; i < maxNameLength - name.length() + 1; i++) {
            formattedName.append(" ");
        }
        formattedName.append(name);
        return formattedName.toString();
    }

    static StringBuilder formatRow(StringBuilder builder) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }

    static StringBuilder formatStepString(StringBuilder builder) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append("-");
        }
        return builder;
    }

    static StringBuilder formatSpaceString(StringBuilder builder) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }
}