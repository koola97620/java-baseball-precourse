package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.GameNumberGenerator;
import baseball.domain.GameNumbers;
import baseball.domain.Results;
import baseball.util.NumberUtils;
import baseball.view.InputView;
import baseball.view.PrintView;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());

        GameNumbers numbers = GameNumbers.of(NumberUtils.toList(inputView.inputNumbers()));
        Results results = baseballGame.start(numbers);

        printView.print(results.createResultsMessage());


    }
}
