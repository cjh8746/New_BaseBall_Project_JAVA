package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameOneRoundTest {
    private static final int BALL = 2;
    private GameOneRound gameOneRound;

    @ParameterizedTest
    @MethodSource("threeStrikeCountParameterProvider")
    @DisplayName("threeStrike 인 경우 true 반환을 확인.")
    void isOver(List<Baseball> inputNumbers, List<Baseball> randomNumbers, boolean expect) {
        GameOneRound gameOneRound = new GameOneRound(inputNumbers, randomNumbers);
        boolean resultStrikeCount = gameOneRound.isThreeStrike();
        assertThat(resultStrikeCount).isEqualTo(expect);
    }

    static Stream<Arguments> threeStrikeCountParameterProvider() {
        return Stream.of(arguments(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)),
                        Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)), true),

                arguments(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)),
                        Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0)), false),

                arguments(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)),
                        Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2)), false),

                arguments(Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0)),
                        Arrays.asList(new Baseball(new BaseballNumber("1"), 2), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 0)), true),

                arguments(Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2)),
                        Arrays.asList(new Baseball(new BaseballNumber("4"), 0), new Baseball(new BaseballNumber("5"), 1), new Baseball(new BaseballNumber("6"), 2)), true));
    }

    @ParameterizedTest
    @MethodSource("threeBaseballsParameterProvider")
    @DisplayName("객체 생성시 라운드 카운트를 1로 초기화 하는지 확인")
    void checkResetRoundCount(List<Baseball> inputBaseballs, List<Baseball> randomBaseballs) {
        gameOneRound = new GameOneRound(inputBaseballs, randomBaseballs);
        assertThat(gameOneRound.getRoundCount()).isEqualTo(1);
    }

    static Stream<Arguments> threeBaseballsParameterProvider() {
        return Stream.of(arguments(Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2)),
                Arrays.asList(new Baseball(new BaseballNumber("1"), 0), new Baseball(new BaseballNumber("2"), 1), new Baseball(new BaseballNumber("3"), 2))));
    }
}