package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_INVALID_ROUND = "[ERROR] 횟수는 1 이상의 정수여야 합니다.";

    public String readCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public int readRoundCount() {
        System.out.println(ROUND_COUNT_PROMPT);
        try {
            int roundCount = Integer.parseInt(Console.readLine());
            validateRoundCount(roundCount);
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ROUND);
        }
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_ROUND);
        }
    }
}
