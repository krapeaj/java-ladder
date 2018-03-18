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
            Point point = row.onPoint(player.getPosition()); //현재 플레이어의 포지션에 해당하는 포인트를 호출
            player.changePosition(point.assignNextIndex()); //그 포인트에 해당하는 방향(왼쪽/오른쪽)에 따른 플레이어의 포지션 증가/감소
        }
    }
}