package chess.domain.team;

import java.util.Objects;

public class Score implements Comparable<Score> {

    public static final Score ZERO = new Score(0);
    private final double score;

    public Score(double value) {
        this.score = value;
    }


    public Score add(Score value) {
        return new Score(value.score + this.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Score)) {
            return false;
        }
        Score score1 = (Score) o;
        return Double.compare(score1.score, score) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }

    @Override
    public int compareTo(Score o) {
        return Double.compare(score, o.score);
    }

}
