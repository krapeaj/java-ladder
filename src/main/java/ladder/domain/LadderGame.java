package ladder.domain;

import ladder.view.LadderBuilder;
import ladder.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private List<Row> ladder = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    public LadderGame(String names, String inputPrizes, int ladderHeight) {
        String[] splitNames = names.split(",\\s*");

        Player player;
        for (int i = 0; i < players.size(); i++) {
            player = new Player(splitNames[i], i);
            players.add(player);
        }

        Prize prize;
        for (String item : inputPrizes.split(",\\s*")) {
            prize = new Prize(item);
            prizes.add(prize);
        }

        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(splitNames.length);
            ladder.add(row);
        }
    }

    public String startConversion() {
        LadderBuilder ladderBuilder = new LadderBuilder();

        return ladderBuilder.buildLadder(ladder, players);
    }

    public Map<Player, Prize> generateResult(){
        Result result = new Result();
        return result.drawResult(ladder, players, prizes);
    }
}