package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("두 boolean 값에 따라 다른 Result 생성")
    @ParameterizedTest
    @CsvSource(value = {"true,true,STRIKE", "true,false,BALL", "false,false,NOTHING"})
    void create(boolean isContainNumber, boolean isSamePosition, String expected) {
        Result result = Result.of(isContainNumber, isSamePosition);
        assertThat(result).isEqualTo(Result.valueOf(expected));
    }
}
