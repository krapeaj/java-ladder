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

    private boolean assignRandomBoolean(Random random, boolean prevBool) {
        boolean currentBool;
        if (prevBool) {
            currentBool = false;
            rowOfRandomBooleans.add(currentBool);
            return currentBool;
        }
        currentBool = random.nextBoolean();
        rowOfRandomBooleans.add(currentBool);
        return currentBool;
    }

    public void returnRowWithRandomBooleans(StringBuilder builder) {
        for (boolean bool : rowOfRandomBooleans) {
            addStepString(bool, builder);
            addEmptyString(bool, builder);
        }
    }

    private void addStepString(Boolean bool, StringBuilder builder) {
        if (bool) {
            builder.append(Output.returnLadderFrame());
            builder.append(Output.returnLadderStep());
        }
    }

    private void addEmptyString(Boolean bool, StringBuilder builder) {
        if (!bool) {
            builder.append(Output.returnLadderFrame());
            builder.append(Output.returnEmptyString());
        }
    }
}