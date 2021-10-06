package baseball;

import baseball.domain.GameNumbers;
import baseball.domain.Number;
import baseball.util.NumberUtils;
import baseball.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        InputView inputView = new InputView();

        List<Number> numbers = NumberUtils.toList(inputView.inputNumbers());


    }
}
