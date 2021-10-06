package baseball.domain;

public class BaseballGame {
    private static final int NEW_GAME_COMMAND_NUMBER = 1;
    private static final int END_GAME_COMMAND_NUMBER = 2;

    private final NumberGenerator numberGenerator;
    private GameNumbers gameNumbers;
    private Results results;
    private boolean isGameOver;

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.gameNumbers = numberGenerator.generate();
    }

    public Results start(GameNumbers numbers) {
        this.results = getGameResult(numbers);
        return results;
    }

    private Results getGameResult(GameNumbers inputNumbers) {
        return gameNumbers.calculateResults(inputNumbers);
    }

    public boolean isEnd() {
        if (isNotYetGameStart()) {
            return false;
        }
        this.isGameOver = results.isThreeStrike();
        return isGameOver;
    }

    private boolean isNotYetGameStart() {
        return results == null;
    }

    public void executeCommand(Integer commandNumber) {
        if (commandNumber == NEW_GAME_COMMAND_NUMBER) {
            gameReset();
        }

        if (commandNumber == END_GAME_COMMAND_NUMBER) {
            endGame();
        }
    }

    private void endGame() {
        this.isGameOver = true;
    }

    private void gameReset() {
        this.gameNumbers = numberGenerator.generate();
        this.results = null;
        this.isGameOver = false;
    }
}
