package baseball.view;

import nextstep.utils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";

    public String inputNumbers() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
