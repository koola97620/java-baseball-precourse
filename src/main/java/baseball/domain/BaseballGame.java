package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private NumberGenerator numberGenerator;
    private GameNumbers gameNumbers;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public Results start(GameNumbers numbers) {
        return matchResult(numbers);
    }

    private Results matchResult(GameNumbers inputNumbers) {
        return gameNumbers.calculateResults(inputNumbers);
    }

}
