package racingcar.domain;

public class RoundValidator {

    private static final String ERROR_INVALID_ROUND = "[ERROR] 횟수는 1 이상의 정수여야 합니다.";
    private static final int MINIMUM_COUNT = 1;

    public int validateAndParse(String roundCountInput) {
        int roundCount = parseToInteger(roundCountInput);
        validateMinimumCount(roundCount);
        return roundCount;
    }

    private int parseToInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ROUND);
        }
    }

    private void validateMinimumCount(int roundCount) {
        if (roundCount < MINIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_ROUND);
        }
    }
}
