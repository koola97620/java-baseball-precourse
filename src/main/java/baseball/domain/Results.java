package baseball.domain;

import baseball.exception.BaseballGameFailureException;
import baseball.exception.ErrorCode;

import java.util.List;
import java.util.StringJoiner;

public class Results {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String OUT_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;


    private List<Result> results;
    private int strikeCount;
    private int ballCount;

    public Results(List<Result> results) {
        validate(results);
        this.results = results;
        makeResultStatistics();
    }

    private void validate(List<Result> results) {
        if (results.size() > MAX_COUNT) {
            throw new BaseballGameFailureException(ErrorCode.RESULT_SIZE_ERROR.getMessage());
        }
    }

    public String createResultsMessage() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        createStrikeMessage(stringJoiner);
        createBallMessage(stringJoiner);
        return stringJoiner.toString().isEmpty() ? NOTHING : stringJoiner.toString();
    }

    private void createStrikeMessage(StringJoiner stringJoiner) {
        if (strikeCount > MIN_COUNT) {
            stringJoiner.add(Integer.toString(strikeCount) + STRIKE);
        }

        if (strikeCount == MAX_COUNT) {
            stringJoiner.add(OUT_MESSAGE);
        }
    }

    private void createBallMessage(StringJoiner stringJoiner) {
        if (ballCount > MIN_COUNT) {
            stringJoiner.add(Integer.toString(ballCount) + BALL);
        }
    }


    private void makeResultStatistics() {
        for (Result result : results) {
            count(result);
        }
    }

    private void count(Result result) {
        if (result.equals(Result.STRIKE)) strikeCount++;
        if (result.equals(Result.BALL)) ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
