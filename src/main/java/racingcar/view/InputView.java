package racingcar.view;

import racingcar.domain.RoundValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    private final RoundValidator roundValidator;

    public InputView(RoundValidator roundValidator) {
        this.roundValidator = roundValidator;
    }

    public String readCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public int readRoundCount() {
        System.out.println(ROUND_COUNT_PROMPT);
        String input = Console.readLine();
        return roundValidator.validateAndParse(input);
    }
}
