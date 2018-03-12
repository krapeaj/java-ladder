package ladder.game;

import java.util.ArrayList;
import java.util.Random;

public class Row {
    private ArrayList<Boolean> rowOfRandomBooleans = new ArrayList<>();

    Row(int numberOfPeople) {
        Random random = new Random();

        Boolean prevBool = false;
        for (int i = 0; i < numberOfPeople - 1; i++) {
            prevBool = assignRandomBoolean(random, prevBool);
        }
    }

    private boolean assignRandomBoolean(Random random, Boolean prevBool) {
        Boolean currentBool;
        if (prevBool) {
            currentBool = false;
            rowOfRandomBooleans.add(currentBool);
            return currentBool;
        }
        currentBool = random.nextBoolean();
        rowOfRandomBooleans.add(currentBool);
        return currentBool;
    }

    public ArrayList<Boolean> getRowOfRandomBooleans() {
        return this.rowOfRandomBooleans;
    }
}