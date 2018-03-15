package ladder.domain;

import java.util.ArrayList;

public class Row {
    private ArrayList<Boolean> rowOfRandomBools = new ArrayList<>();

    Row(int numberOfPeople) {
        Boolean bool = false;
        for (int i = 0; i < 2 * numberOfPeople - 1; i++){
            if(i % 2 == 0){
                rowOfRandomBools.add(true);
                continue;
            }
            bool = assignRandomBool(bool);
            rowOfRandomBools.add(bool);
        }
    }

    private boolean assignRandomBool(Boolean bool) {
        if (bool) {
            return false;
        }
        return GameUtils.generateRandomBools();
    }

    public boolean isStep(int booleanPosition) {
        return rowOfRandomBools.get(booleanPosition);
    }

    ArrayList<Boolean> getRow() {
        return rowOfRandomBools;
    }
}