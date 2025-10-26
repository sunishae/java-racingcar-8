package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCheck {

    public List<String> getWinners(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        return filterWinners(carList, maxPosition);
    }

    private int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private List<String> filterWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            addWinnerIfEqualPosition(car, maxPosition, winners);
        }
        return winners;
    }

    private void addWinnerIfEqualPosition(Car car, int maxPosition, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}
