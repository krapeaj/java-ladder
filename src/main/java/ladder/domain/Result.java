package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Player, Integer> positions = new HashMap<>();

    public Map<Player, Prize> drawResult(List<Row> ladder, List<Player> players, List<Prize> prizes){
        for(Player player : players){
            positions.put(player, player.getInitPosition());
            climbDownLadder(ladder, player);
        }

        Map<Player, Prize> result = new HashMap<>();
        for(Player player : players){
            int prizeIndex = positions.get(player);
            result.put(player, prizes.get(prizeIndex));
        }
        return result;
    }

    public void climbDownLadder(List<Row> ladder, Player player){
        for(Row row : ladder){
            moveRightOrLeft(row, player);
        }
    }

    public void moveRightOrLeft(Row row, Player player){
        for(int i = positions.get(player); i < row.getRowLength(); i += 2){
            if(moveLeft(player, i)){
                break;
            }
            if(moveRight(player, i, row)){
                break;
            }
        }
    }

    public boolean moveLeft(Player player, int i){
        if(isOnFrame(i)){
            return false;
        }
        if(isOnLeftEnd(i)){
            return false;
        }
        positions.replace(player, positions.get(player) - 1);
        return true;
    }

    public boolean isOnFrame(int i){
        return (i % 2 != 0);
    }

    public boolean isOnLeftEnd(int i){
        return i == 0;
    }

    public boolean moveRight(Player player, int i, Row row){
        if(isOnFrame(i)){
            return false;
        }
        if(isOnRightEnd(i, row)){
            return false;
        }
        positions.replace(player,positions.get(player) + 1);
        return true;
    }

    public boolean isOnRightEnd(int i, Row row){
        return i == row.getRowLength();
    }

    public Map<Player, Integer> getPositions(){
        return positions;
    }
}
