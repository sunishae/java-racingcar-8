package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_MARK = "-";
    private static final String ROUND_START_MESSAGE = "\n실행 결과";
    private static final String CAR_POSITION_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printStartMessage() {
        System.out.println(ROUND_START_MESSAGE);
    }

    public void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        String hyphens = getPositionRepresent(car.getPosition());
        System.out.println(car.getName() + CAR_POSITION_DELIMITER + hyphens);
    }

    // 자동차의 position을 hyphen(-)으로 표현
    private String getPositionRepresent(int position) {
        return POSITION_MARK.repeat(position);
    }

    public void printWinners(List<String> winners) {
        String winnersOutput = String.join(WINNER_DELIMITER, winners);
        System.out.println(WINNER_MESSAGE + winnersOutput);
    }
}