package ladder.domain;

public class LadderFormat {

    static String formatNameString(String name, int maxNameLength) {
        StringBuilder formattedName = new StringBuilder();

        for (int i = 0; i < maxNameLength - name.length() + 1; i++) {
            formattedName.append(" ");
        }
        formattedName.append(name);
        return formattedName.toString();
    }

    static StringBuilder formatRow(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }

    static StringBuilder formatStepString(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append("-");
        }
        return builder;
    }

    static StringBuilder formatSpaceString(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }
}