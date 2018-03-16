package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Player, Integer> positions = new LinkedHashMap<>();

    public Map<String, String> drawResult(List<Row> ladder, List<Player> players, List<Prize> prizes) {
        for (Player player : players) {
            positions.put(player, player.getInitPosition());
            climbDownLadder(ladder, player);
        }

        Map<String, String> result = new LinkedHashMap<>();
        for (Player player : players) {
            int prizeIndex = positions.get(player);
            result.put(player.getName(), prizes.get(prizeIndex).getName());
        }
        return result;
    }

    public void climbDownLadder(List<Row> ladder, Player player) {
        for (Row row : ladder) {
            moveRightOrLeft(row, player);
        }
    }

    public void moveRightOrLeft(Row row, Player player) {
        for (int rowIndex = 2 * positions.get(player); rowIndex < row.getRowLength(); rowIndex ++) {
            if (moveLeft(player, rowIndex)) {
                break;
            }
            if (moveRight(player, rowIndex, row)) {
                break;
            }
        }
    }

    public boolean moveLeft(Player player, int rowIndex) {
        if (isOnLeftEnd(rowIndex)) {
            return false;
        }
        if (isOnFrame(rowIndex - 1)) {
            return false;
        }
        positions.replace(player, positions.get(player) - 1);
        return true;
    }

    public boolean isOnFrame(int rowIndex) {
        return (rowIndex % 2 == 0);
    }

    public boolean isOnLeftEnd(int rowIndex) {
        return rowIndex == 0;
    }

    public boolean moveRight(Player player, int rowIndex, Row row) {
        if (isOnRightEnd(rowIndex, row)) {
            return false;
        }
        if (isOnFrame(rowIndex + 1)) {
            return false;
        }
        positions.replace(player, positions.get(player) + 1);
        return true;
    }

    public boolean isOnRightEnd(int rowIndex, Row row) {
        return rowIndex == row.getRowLength();
    }

    public Map<Player, Integer> getPositions() {
        return positions;
    }
}
