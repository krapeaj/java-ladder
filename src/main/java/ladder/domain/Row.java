package ladder.domain;

import java.util.ArrayList;

public class Row {
    private ArrayList<Boolean> booleanRow = new ArrayList<>();

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
            booleanRow.add(currentBool);
            return currentBool;
        }
        currentBool = GameUtils.generateRandomBoolean();
        booleanRow.add(currentBool);
        return currentBool;
    }

    boolean isStep(int booleanPosition) {
        return booleanRow.get(booleanPosition);
    }

    ArrayList<Boolean> getRow() {
        return booleanRow;
    }
}