package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.GameNumberGenerator;
import baseball.domain.GameNumbers;
import baseball.util.NumberUtils;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        InputView inputView = new InputView();
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());

        GameNumbers numbers = GameNumbers.of(NumberUtils.toList(inputView.inputNumbers()));
        baseballGame.start(numbers);



    }
}
