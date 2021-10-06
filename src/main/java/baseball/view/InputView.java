package baseball.view;

import nextstep.utils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String CONTINUE_OT_STOP_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputNumbers() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public Integer inputCommand() {
        System.out.println(CONTINUE_OT_STOP_GAME_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
