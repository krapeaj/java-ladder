package ladder.domain;

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

    private void climbDownLadder(List<Row> ladder, Player player) {
        for (Row row : ladder) {
            moveRightOrLeft(row, player);
        }
    }

    private Map<Player, Integer> moveRightOrLeft(Row row, Player player) {
        int position = positions.get(player);

        if (moveLeft(row, player, position)) { // 왼쪽 체크
            return positions;
        }
        if (moveRight(row, player, position)) { // 오른쪽 체크
            return positions;
        }
        return positions; // else: position unchanged
    }

    private boolean moveLeft(Row row, Player player, int position) {
        int leftIndex = 2 * position - 1;
        if (isOnLeftEnd(position)) {
            return false;
        }
        if (row.isStep(leftIndex)) {
            positions.put(player, positions.get(player) - 1);
            return true;
        }
        return false;
    }

    private boolean isOnLeftEnd(int position) {
        return position == 0;
    }

    private boolean moveRight(Row row, Player player, int position) {
        int rightIndex = 2 * position + 1;
        if (isOnRightEnd(position, row)) {
            return false;
        }
        if (row.isStep(rightIndex)) {
            positions.put(player, positions.get(player) + 1);
            return true;
        }
        return false;
    }

    private boolean isOnRightEnd(int position, Row row) {
        return 2 * position == row.getRowLength() - 1;
    }
}
