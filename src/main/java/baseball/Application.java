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
    private static final int NEW_GAME_COMMAND_NUMBER = 1;
    private static final int END_GAME_COMMAND_NUMBER = 2;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());

        while (!baseballGame.isEnd()) {
            startGame(inputView, printView, baseballGame);
            continueOrStopGame(baseballGame, inputView);
        }
    }

    private static void startGame(InputView inputView, PrintView printView, BaseballGame baseballGame) {
        try {
            GameNumbers numbers = GameNumbers.of(NumberUtils.toList(inputView.inputNumbers()));
            Results results = baseballGame.start(numbers);
            printView.print(results.createResultsMessage());
        } catch (BaseballGameFailureException e) {
            printView.print(e.getMessage());
        }
    }

    private static void continueOrStopGame(BaseballGame game, InputView inputView) {
        if (!game.isEnd()) {
            return;
        }
        Integer commandNumber = inputCommandNumber(inputView);
        game.executeCommand(commandNumber);
    }

    private static Integer inputCommandNumber(InputView inputView) {
        Integer commandNumber = inputView.inputCommand();
        while (!validCommandNumber(commandNumber)) {
            commandNumber = inputView.inputCommand();
        }
        return commandNumber;
    }

    private static boolean validCommandNumber(Integer commandNumber) {
        return commandNumber == NEW_GAME_COMMAND_NUMBER || commandNumber == END_GAME_COMMAND_NUMBER;
    }
}