package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinnerCheck 우승자 판별 테스트")
class WinnerCheckTest {

    private final WinnerCheck winnerCheck = new WinnerCheck();

    @Test
    @DisplayName("최종 포지션이 가장 높은 자동차가 하나면 단독 우승자로 추출해야 한다.")
    void getWinners_SingleWinner_ReturnsCorrectName() {
        // given
        List<Car> carList = Arrays.asList(
                new Car("pobi", 5),
                new Car("woni", 3),
                new Car("jun", 4)
        );

        // when
        List<String> winners = winnerCheck.getWinners(carList);

        // then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("최종 포지션이 여러 자동차가 동일한 경우 공동 우승자로 추출해야 한다.")
    void getWinners_MultipleWinners_ReturnsAllNames() {
        // given
        List<Car> carList = Arrays.asList(
                new Car("woni", 3),
                new Car("pobi", 5),
                new Car("jun", 5),
                new Car("haech", 3)
        );

        // when
        List<String> winners = winnerCheck.getWinners(carList);

        // then
        assertThat(winners).containsExactly("pobi", "jun");
    }
}
