package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            if(i < rowOfSteps.size()){
                row.add(new Point(rowOfSteps.get(i)));
            }
            Random random = new Random();
            row.add(new Point(random.nextBoolean()));
        }
    }

    private boolean assignRandomBool(Boolean bool) {
        if (bool) {
            return false;
        }
        return GameUtils.generateRandomBools();
    }

    public Point onPoint(int column){
        return row.get(column);
    }

    public Point prevPoint(int column){
        if(column == 0){ //when there is no prev
            return row.get(column);
        }
        return row.get(column - 1);
    }

    public Point nextPoint(int column){
        if(column + 1 == row.size()){
            return row.get(column);
        }
        return row.get(column + 1);
    }

    public int getRowLength(){
        return rowOfSteps.size();
    }

    public boolean isStep(int booleanPosition) {
        return rowOfSteps.get(booleanPosition);
    }
}


//---------------------------------------------------------------------------------------------------

    /*

    Row(int numberOfPeople) {

    }





    public int getRowLength() {
        return rowOfSteps.size();
    }

    List<Boolean> getRow() {
        return rowOfSteps;
    }
}
*/