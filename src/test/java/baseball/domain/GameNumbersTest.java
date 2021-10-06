package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumbersTest {

    @DisplayName("숫자가 3개가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void length(String numberString) {
        assertThatThrownBy(() -> GameNumbers.of(numberString))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("숫자의 길이는 3자리여야 합니다.");
    }

    @DisplayName("서로 다른 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"222", "333", "122", "331"})
    void duplicate(String numberString) {
        assertThatThrownBy(() -> GameNumbers.of(numberString))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("숫자는 서로 다른 숫자여야 합니다.");
    }

    @DisplayName("gameNumbers 에 포함된 숫자 존재 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"5,0,458,true", "8,1,812,true", "3,0,412,false", "5,0,132,false", "9,2,912,true"})
    void containNumber(int number, int position, String numbers, boolean expected) {
        Number inputNumber = Number.of(number, position);
        GameNumbers gameNumbers = GameNumbers.of(numbers);

        boolean result = gameNumbers.isContainNumber(inputNumber);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("gameNumbers 에 포함되고 숫자값과 위치가 동일한 숫자 존재 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"5,1,458,true", "8,0,812,true", "3,0,412,false", "3,1,132,true", "2,2,912,true"})
    void containNumberAndSamePosition(int number, int position, String numbers, boolean expected) {
        Number inputNumber = Number.of(number, position);
        GameNumbers gameNumbers = GameNumbers.of(numbers);

        boolean result = gameNumbers.isSamePosition(inputNumber);

        assertThat(result).isEqualTo(expected);
    }

}