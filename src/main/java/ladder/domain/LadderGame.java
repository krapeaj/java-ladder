package ladder.domain;

import ladder.view.LadderBuilder;
import ladder.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private List<Row> ladder = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public LadderGame(String names, String inputPrizes, int ladderHeight) {
        String[] splitNames = names.split(",\\s*");

        Player player;
        for (String name : splitNames) {
            player = new Player(name);
            players.add(player);
        }

        List<Prize> prizes = new ArrayList<>();
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

    public String startBuild() {
        LadderBuilder ladderBuilder = new LadderBuilder();

        return ladderBuilder.buildLadder(ladder, players);
    }
}