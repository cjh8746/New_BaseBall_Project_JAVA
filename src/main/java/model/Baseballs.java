package model;

import java.util.List;
import java.util.stream.Collectors;

public class Baseballs {
    private static final int STRIKE = 1;
    private static final int BALL = 2;
    private static final int NOTHING = 0;

    private List<Baseball> threeBalls;

    public Baseballs(List<Baseball> threeBalls) {
        this.threeBalls = threeBalls;
    }

    public List<Integer> compareThreeBall(Baseballs another) {
        return threeBalls.stream()
                .map(another::compareBall)
                .collect(Collectors.toList());
    }

    private int compareBall(Baseball anotherBalls) {
        return threeBalls.stream()
                .map(anotherBalls::checkBaseball)
                .filter(ballStatus -> ballStatus == BALL || ballStatus == STRIKE)
                .findAny()
                .orElse(NOTHING);
    }
}
