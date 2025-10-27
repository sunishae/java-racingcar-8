package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ParseCar {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INPUT_DELIMITER = ",";
    private static final String ERROR_INVALID_CAR_NAME = "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.";

    public List<Car> parse(String inputString) {

        String trimmedInput = inputString.trim();
        String[] carNames = trimmedInput.split(INPUT_DELIMITER);

        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            String trimedCarName = carName.trim();
            validateName(trimedCarName);
            carList.add(new Car(trimedCarName));
        }

        return carList;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }
}
