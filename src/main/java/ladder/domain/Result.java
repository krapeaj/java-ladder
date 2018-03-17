package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public Map<String, String> drawResult(List<Row> ladder, List<Player> players, List<Prize> prizes) {
        for (Player player : players) {
            climbDownLadder(ladder, player);
        }
        Map<String, String> result = new LinkedHashMap<>();
        for (Player player : players) {
            Prize prize = prizes.get(player.getPosition());
            result.put(player.getName(), prize.getName());
        }
        return result;
    }

    private void climbDownLadder(List<Row> ladder, Player player) {
        for (Row row : ladder) {
            Point point = row.onPoint(player.getPosition());
            player.changePosition(point.giveDirection());
        }
    }
}