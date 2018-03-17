package ladder.domain;

import ladder.view.LadderBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private List<Row> ladder = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    public LadderGame(String names, String inputPrizes, int ladderHeight) {
        String[] splitNames = names.split(",\\s*");
        for (int i = 0; i < splitNames.length; i++) {
            players.add(new Player(splitNames[i], i));
        }

        for (String item : inputPrizes.split(",\\s*")) {
            prizes.add(new Prize(item));
        }

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(splitNames.length));
        }
    }

    public String startConversion() {
        LadderBuilder ladderBuilder = new LadderBuilder();

        return ladderBuilder.buildLadder(ladder, players, prizes);
    }

//    public Map<String, String> generateResult() {
//        Result result = new Result(); // static factory method?
//        return result.drawResult(ladder, players, prizes);
//
//    }
}

