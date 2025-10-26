package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RoundValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RoundValidator 시도 횟수 유효성 테스트")
public class RoundValidatorTest {

    private final RoundValidator validator = new RoundValidator();
    private static final String ERROR_MESSAGE = "[ERROR] 횟수는 1 이상의 정수여야 합니다.";

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "ten", "", " "})
    @DisplayName("시도 횟수가 정수가 아니거나 공백이면 예외가 발생한다.")
    void validateRoundCount_WhenInputIsNotInteger_ThrowsException(String invalidInput) {
        // RoundValidator의 validateAndParse 메서드가 NumberFormatException을 잡아
        // IllegalArgumentException으로 변환하는지 검증
        assertThatThrownBy(() -> validator.validateAndParse(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다.")
    void validateRoundCount_WhenInputIsLessThanOne_ThrowsException(String invalidInput) {
        // 1 미만의 숫자는 Integer.parseInt를 통과하지만 validateMinimumCount에서 예외를 던지는지 검증
        assertThatThrownBy(() -> validator.validateAndParse(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    // 추가: 성공 케이스 테스트 (선택적이지만 권장)
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100 "}) // 공백이 있어도 trim 후 파싱되는지 검증
    @DisplayName("유효한 숫자와 공백은 성공적으로 정수로 파싱되어야 한다.")
    void validateRoundCount_WhenInputIsValid_ReturnsInteger(String validInput) {
        // when
        int result = validator.validateAndParse(validInput);

        // then
        // 결과가 1 이상인지 확인
        assertThat(result).isGreaterThanOrEqualTo(1);
        // 공백이 제거된 후 파싱되었는지 확인 (e.g., "100 " -> 100)
        assertThat(result).isEqualTo(Integer.parseInt(validInput.trim()));
    }
}
