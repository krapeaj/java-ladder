package ladder.domain;

import java.util.ArrayList;

public class Row {
    private ArrayList<Boolean> rowOfRandomBools = new ArrayList<>();

    Row(int numberOfPeople) {
        Boolean bool = false;
        for (int i = 0; i < numberOfPeople - 1; i++) {
            bool = assignRandomBoolean(bool);
            rowOfRandomBools.add(bool);
        }
    }

    private boolean assignRandomBoolean(Boolean bool) {
        if (bool) {
            return false;
        }
        return GameUtils.generateRandomBoolean();
    }

    boolean isStep(int booleanPosition) {
        return rowOfRandomBools.get(booleanPosition);
    }

    ArrayList<Boolean> getRow() {
        return rowOfRandomBools;
    }
}