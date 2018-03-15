package ladder.domain;

import ladder.view.LadderBuilder;
import ladder.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    LadderDTO dto = new LadderDTO();

    public LadderGame(String names, String inputPrizes, int ladderHeight) {
        List<Player> players = new ArrayList<>();
        Player player;
        for(String name : names.split(",\\s*")){
            player = new Player(name);
            players.add(player);
        }
        dto.setPlayers(players);

        List<Prize> prizes = new ArrayList<>();
        Prize prize;
        for(String item : inputPrizes.split(",\\s*")){
            prize = new Prize(item);
            prizes.add(prize);
        }
        dto.setPrizes(prizes);

        List<Row> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Row row = new Row(dto.getPlayers().size());
            ladder.add(row);
        }
        dto.setLadder(ladder);
    }

    public LadderDTO startBuild() {
        return LadderBuilder.buildLadder(dto);
    }
}