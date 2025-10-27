package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 도메인 테스트")
public class CarTest {

    private final static int INITIAL_POSITION = 0;
    private final static String TEST_NAME = "test";

    // 난수 4 이상: 전진
    private final static int MOVING_NUMBER = 4;
    private final static int MOVING_NUMBER_MAX = 9;

    // 난수 3 이하: 멈춤
    private final static int STOPPING_NUMBER = 3;
    private final static int STOPPING_NUMBER_MIN = 0;

    @Test
    @DisplayName("4 이상이 난수면 자동차는 1칸 전진한다.")
    void When_FourOrGreater_Expect_MoveForward() {
        //given
        Car carMin = new Car(TEST_NAME);
        Car carMax = new Car(TEST_NAME);

        //when
        carMin.move(MOVING_NUMBER);
        carMax.move(MOVING_NUMBER_MAX);

        //then
        assertThat(carMin.getPosition()).isEqualTo(INITIAL_POSITION + 1);
        assertThat(carMax.getPosition()).isEqualTo(INITIAL_POSITION + 1);
    }

    @Test
    @DisplayName("3 이하이 난수면 자동차는 움직이지 않는다.")
    void When_ThreeOrLess_Expect_DoNotMove() {
        //given
        Car carMin = new Car(TEST_NAME);
        Car carMax = new Car(TEST_NAME);

        //when
        carMin.move(STOPPING_NUMBER_MIN);
        carMax.move(STOPPING_NUMBER);

        //then
        assertThat(carMin.getPosition()).isEqualTo(INITIAL_POSITION);
        assertThat(carMax.getPosition()).isEqualTo(INITIAL_POSITION);
    }
}
