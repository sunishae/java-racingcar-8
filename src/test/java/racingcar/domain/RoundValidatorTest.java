package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("RoundValidator 시도 횟수 유효성 테스트")
public class RoundValidatorTest {

    private final RoundValidator validator = new RoundValidator();
    private static final String ERROR_MESSAGE = "[ERROR] 횟수는 1 이상의 정수여야 합니다.";

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "ten", "", " "})
    @DisplayName("시도 횟수가 정수가 아니거나 공백이면 예외가 발생한다.")
    void validateRoundCount_WhenInputIsNotInteger_ThrowsException(String invalidInput) {
        assertThatThrownBy(() -> validator.validateAndParse(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다.")
    void validateRoundCount_WhenInputIsLessThanOne_ThrowsException(String invalidInput) {
        assertThatThrownBy(() -> validator.validateAndParse(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
