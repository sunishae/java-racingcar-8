package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.ParseCar;
import racingcar.domain.RaceGame;
import racingcar.domain.RoundValidator;
import racingcar.domain.WinnerCheck;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RoundValidator roundValidator = new RoundValidator();
        InputView inputView = new InputView(roundValidator);
        OutputView outputView = new OutputView();
        ParseCar parseCar = new ParseCar();
        RaceGame raceGame = new RaceGame();
        WinnerCheck winnerCheck = new WinnerCheck();

        RaceController raceController = new RaceController(
                inputView,
                outputView,
                parseCar,
                raceGame,
                winnerCheck
        );

        raceController.run();
    }
}
