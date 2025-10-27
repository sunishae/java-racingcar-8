package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ParseCar 파싱 및 유효성 테스트")
class ParseCarTest {
    
    private static final String EXCEPTION_MESSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private final ParseCar parser = new ParseCar();

    @Test
    @DisplayName("유효한 이름은 콤마(,)를 기준으로 Car 객체 리스로 정확히 파싱되어야 한다.")
    void parse_ValidNames_ReturnsCarList() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<Car> carList = parser.parse(input);

        // then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,123456", "123456,woni,jun"})
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void When_NameLengthExceeded_Then_ThrowsException(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",woni", "pobi,,jun", " "})
    @DisplayName("이름이 빈 문자열이거나 쉼표로 시작하는 경우 예외가 발생한다.")
    void When_NameIsEmpty_Then_ThrowsException(String input) {
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE);
    }
}
