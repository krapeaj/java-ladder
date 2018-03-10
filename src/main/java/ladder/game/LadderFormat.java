package ladder.game;

public class LadderFormat {

    public static String formatNameString(String name, int maxNameLength) {
        StringBuilder formattedName = new StringBuilder();
        for (int i = 0; i < maxNameLength - name.length() + 1; i++) {
            formattedName.append(" ");
        }
        formattedName.append(name);
        return formattedName.toString();
    }

    public static StringBuilder formatRow(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }

    public static StringBuilder formatStepString(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append("-");
        }
        return builder;
    }

    public static StringBuilder formatEmptyString(StringBuilder builder, int maxNameLength) {
        for (int i = 0; i < maxNameLength; i++) {
            builder.append(" ");
        }
        return builder;
    }
}