package ladder.domain;

import java.util.ArrayList;

public class Row {
    private ArrayList<Boolean> rowOfRandomBooleans = new ArrayList<>();

    Row(int numberOfPeople) {
        Boolean prevBool = false;
        for (int i = 0; i < numberOfPeople - 1; i++) {
            prevBool = assignRandomBoolean(prevBool);
        }
    }

    private boolean assignRandomBoolean(Boolean prevBool) {
        Boolean currentBool;
        if (prevBool) {
            currentBool = false;
            rowOfRandomBooleans.add(currentBool);
            return currentBool;
        }
        currentBool = GameUtils.generateRandomBoolean();
        rowOfRandomBooleans.add(currentBool);
        return currentBool;
    }

    public boolean isStep(int booleanPosition) {
        if (this.rowOfRandomBooleans.get(booleanPosition)) {
            return true;
        }
        return false;
    }
}