package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumbersTest {

    @DisplayName("숫자가 3개가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1","12","1234","12345"})
    void length(String numberString) {
        assertThatThrownBy(() -> GameNumbers.of(numberString))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("숫자의 길이는 3자리여야 합니다.");
    }

    @DisplayName("서로 다른 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"222","333","122","331"})
    void duplicate(String numberString) {
        assertThatThrownBy(() -> GameNumbers.of(numberString))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("숫자는 서로 다른 숫자여야 합니다.");
    }

}