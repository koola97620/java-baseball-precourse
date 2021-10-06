package baseball.domain;

public class BaseballGame {
    private NumberGenerator numberGenerator;
    private GameNumbers gameNumbers;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public Results start(GameNumbers numbers) {
        return getGameResult(numbers);
    }

    private Results getGameResult(GameNumbers inputNumbers) {
        return gameNumbers.calculateResults(inputNumbers);
    }

}
