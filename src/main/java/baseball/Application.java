package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.GameNumberGenerator;
import baseball.domain.GameNumbers;
import baseball.domain.Results;
import baseball.exception.BaseballGameFailureException;
import baseball.util.NumberUtils;
import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());

        while(true) {
            try {
                GameNumbers numbers = GameNumbers.of(NumberUtils.toList(inputView.inputNumbers()));
                Results results = baseballGame.start(numbers);

                printView.print(results.createResultsMessage());

            } catch (BaseballGameFailureException e) {
                printView.print(e.getMessage());
            }

        }

    }
}
