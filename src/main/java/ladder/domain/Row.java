package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Boolean> rowOfSteps = new ArrayList<>();
    private List<Point> row = new ArrayList<>();

    Row(int numberOfPeople) {
        Boolean bool = false;
        for (int i = 0; i < numberOfPeople - 1; i++) {
            bool = assignRandomBool(bool);
            rowOfSteps.add(bool);
        }
        for (int i = 0; i < numberOfPeople; i++) {
            row.add(new Point(rowOfSteps, i));
        }
    }

    private boolean assignRandomBool(Boolean bool) {
        if (bool) {
            return false;
        }
        return GameUtils.generateRandomBools();
    }

    public Point onPoint(int column) {
        return row.get(column);
    }

    public int getRowLength() {
        return rowOfSteps.size();
    }

    public boolean isStep(int booleanPosition) {
        return rowOfSteps.get(booleanPosition);
    }
}