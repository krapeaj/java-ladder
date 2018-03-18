package ladder.domain;

public class Prize implements Item {
    private String prizeName;

    public Prize(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getName() {
        return prizeName;
    }
}