package baseball.domain;

import java.util.List;

public class BaseballGame {
    private NumberGenerator numberGenerator;
    private GameNumbers gameNumbers;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public void start(GameNumbers numbers) {


    }
}
