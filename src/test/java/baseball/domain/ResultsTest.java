package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {


    @DisplayName("Result 는 3개 이하여야 한다.")
    @Test
    void validate() {
        assertThatThrownBy(() -> new Results(Arrays.asList(Result.BALL, Result.BALL, Result.BALL, Result.BALL)))
                .isInstanceOf(BaseballGameFailureException.class)
                .hasMessageContaining("게임결과는 3개 이하여야 합니다.");
    }

    @DisplayName("1스트라이크와 2볼 숫자 계산")
    @Test
    void count_strike_ball() {
        Results results = new Results(Arrays.asList(Result.BALL, Result.STRIKE, Result.BALL));
        assertThat(results.getStrikeCount()).isEqualTo(1);
        assertThat(results.getBallCount()).isEqualTo(2);
    }

    @DisplayName("1스트라이크, 2볼 결과 메시지 생성")
    @Test
    void create_message() {
        Results results = new Results(Arrays.asList(Result.BALL, Result.STRIKE, Result.BALL));
        assertThat(results.createResultsMessage())
                .isEqualTo("1스트라이크 2볼");
    }

    @DisplayName("3스트라이크 결과 메시지 생성")
    @Test
    void create_message_three_strike() {
        Results results = new Results(Arrays.asList(Result.STRIKE, Result.STRIKE, Result.STRIKE));
        assertThat(results.createResultsMessage())
                .isEqualTo("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

}