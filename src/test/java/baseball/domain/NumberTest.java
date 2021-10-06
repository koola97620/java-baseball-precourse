package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("유효범위를 벗어난 숫자가 있는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,10})
    void when_inputNotValidNumber_then_throwException(int number) {
        assertThatThrownBy(() -> Number.of(number,0))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("숫자는 1~9 사이의 숫자여야 합니다.");
    }

}