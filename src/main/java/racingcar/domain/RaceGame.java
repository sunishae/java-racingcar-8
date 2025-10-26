package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RaceGame {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public void race(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            car.move(randomNumber);
        }
    }
}
