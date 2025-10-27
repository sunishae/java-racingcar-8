package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinnerCheck 우승자 판별 테스트")
class WinnerCheckTest {

    private static final int MOVING_NUMBER = 4;

    private final WinnerCheck winnerCheck = new WinnerCheck();

    private Car createCarAtPosition(String name, int targetPosition) {
        Car car = new Car(name);
        for (int i = 0; i < targetPosition; i++) {
            car.move(MOVING_NUMBER);
        }
        return car;
    }

    @Test
    @DisplayName("최종 포지션이 가장 높은 자동차가 하나면 단독 우승자로 추출해야 한다.")
    void getWinners_SingleWinner_ReturnsCorrectName() {
        // given
        List<Car> carList = Arrays.asList(
                createCarAtPosition("haech", 5),
                createCarAtPosition("woni", 3),
                createCarAtPosition("jun", 4)
        );

        // when
        List<String> winners = winnerCheck.getWinners(carList);

        // then
        assertThat(winners).containsExactly("haech");
    }

    @Test
    @DisplayName("최종 포지션이 여러 자동차가 동일한 경우 공동 우승자로 추출해야 한다.")
    void getWinners_MultipleWinners_ReturnsAllNames() {
        // given
        List<Car> carList = Arrays.asList(
                createCarAtPosition("pobi", 5),
                createCarAtPosition("woni", 3),
                createCarAtPosition("jun", 5),
                createCarAtPosition("zuha", 2)
        );

        // when
        List<String> winners = winnerCheck.getWinners(carList);

        // then
        assertThat(winners).containsExactly("pobi", "jun");
    }

    @Test
    @DisplayName("모든 자동차가 동일 위치인 경우 모두 공동 우승자가 되어야 한다.")
    void getWinners_AllSamePosition_ReturnsAllAsWinners() {
        // given
        List<Car> carList = Arrays.asList(
                createCarAtPosition("pobi", 10),
                createCarAtPosition("woni", 10),
                createCarAtPosition("jun", 10)
        );

        // when
        List<String> winners = winnerCheck.getWinners(carList);

        // then
        assertThat(winners).containsExactly("pobi", "woni", "jun");
    }
}
