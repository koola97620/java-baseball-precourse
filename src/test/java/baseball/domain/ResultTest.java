package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {"true,true,STRIKE","true,false,BALL","false,false,NOTHING"})
    void test(boolean isContainNumber, boolean isSamePosition, String expected) {
        Result result = Result.of(isContainNumber, isSamePosition);
        assertThat(result).isEqualTo(Result.valueOf(expected));
    }
}
