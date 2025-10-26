package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.ParseCar;
import racingcar.domain.RaceGame;
import racingcar.domain.WinnerCheck;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ParseCar parseCar;
    private final RaceGame raceGame;
    private final WinnerCheck winnerCheck;

    public RaceController(InputView inputView, OutputView outputView, ParseCar parseCar,
                          RaceGame raceGame, WinnerCheck winnerCheck) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parseCar = parseCar;
        this.raceGame = raceGame;
        this.winnerCheck = winnerCheck;
    }

    public void run() {
        // 1. 입력 및 객체 생성
        String carNamesInput = inputView.readCarNames();
        List<Car> carList = parseCar.parse(carNamesInput);
        int roundCount = inputView.readRoundCount();

        // 2. 경주 실행
        outputView.printStartMessage();
        raceRounds(carList, roundCount);

        // 3. 우승자 판별 및 출력
        List<String> winners = winnerCheck.getWinners(carList);
        outputView.printWinners(winners);
    }

    // 라운드 반복 실행
    private void raceRounds(List<Car> carList, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            raceGame.race(carList);
            outputView.printRoundResult(carList);
        }
    }
}
