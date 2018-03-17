package ladder.domain;

import ladder.view.LadderBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private List<Row> ladder = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    public LadderGame(String[] names, String[] inputPrizes, int ladderHeight) {
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }

        for (String item : inputPrizes) {
            prizes.add(new Prize(item));
        }

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(names.length));
        }
    }

    public String startConversion() {
        LadderBuilder ladderBuilder = new LadderBuilder();

        return ladderBuilder.buildLadder(ladder, players, prizes);
    }

    public Map<String, String> generateResult() {
        Result result = new Result(); // static factory method?
        return result.drawResult(ladder, players, prizes);
    }
}