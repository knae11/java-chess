package chess.domain.position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.domain.TeamColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("잘못된 포지션 위치 - 벗어난 위치")
    void failChessBoardPosition() {
        assertThatThrownBy(() -> Position.valueOf("b9"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 포지션 위치 - 길이초과")
    void failChessBoardPosition1() {
        assertThatThrownBy(() -> Position.valueOf("b10"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 포지션 위치")
    void successChessBoardPosition() {
        assertThatCode(() -> Position.valueOf("b1")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("거리 1인 경우")
    void calculate_distance() {
        final Position position = Position.valueOf("b2");
    }

    @Test
    @DisplayName("십자가 위치 테스트 - 가로방")
    void isCross() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isCross(Position.valueOf("c4"))).isTrue();
        assertThat(c3.isCross(Position.valueOf("c1"))).isTrue();
        assertThat(c3.isCross(Position.valueOf("c7"))).isTrue();
    }

    @Test
    @DisplayName("십자가 위치 테스트향 - 세로방")
    void isCross1() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isCross(Position.valueOf("b3"))).isTrue();
        assertThat(c3.isCross(Position.valueOf("d3"))).isTrue();
        assertThat(c3.isCross(Position.valueOf("f3"))).isTrue();
    }

    @Test
    @DisplayName("십자가 위치 테스트 - 실패")
    void isCross2() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isCross(Position.valueOf("g4"))).isFalse();
        assertThat(c3.isCross(Position.valueOf("b2"))).isFalse();
    }

    @Test
    @DisplayName("대각 위치 테스트향 - 크기 1인 경우")
    void isDiagonal() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isDiagonal(Position.valueOf("b2"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("b4"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("d2"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("d4"))).isTrue();
    }

    @Test
    @DisplayName("대각 위치 테스트향 - 확장 경우")
    void isDiagonal1() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isDiagonal(Position.valueOf("a1"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("g7"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("e1"))).isTrue();
        assertThat(c3.isDiagonal(Position.valueOf("a5"))).isTrue();
    }

    @Test
    @DisplayName("대각 위치 테스트 - 실")
    void isDiagonal2() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isDiagonal(Position.valueOf("c5"))).isFalse();
        assertThat(c3.isDiagonal(Position.valueOf("h4"))).isFalse();
    }

    @Test
    @DisplayName("거리 1인경우 테스트")
    void isDistanceOne() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isDistanceOne(Position.valueOf("c2"))).isTrue();
        assertThat(c3.isDistanceOne(Position.valueOf("c4"))).isTrue();
        assertThat(c3.isDistanceOne(Position.valueOf("d3"))).isTrue();
        //대각선 거리1
        assertThat(c3.isDistanceOne(Position.valueOf("d4"))).isTrue();
    }

    @Test
    @DisplayName("거리 1인경우 테스트 - 실패")
    void isDistanceOne1() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isDistanceOne(Position.valueOf("e5"))).isFalse();
        assertThat(c3.isDistanceOne(Position.valueOf("c1"))).isFalse();
        assertThat(c3.isDistanceOne(Position.valueOf("c5"))).isFalse();
    }

    @Test
    @DisplayName("블랙의 경우 앞 방향인지 확인")
    void isFront() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isFront(Position.valueOf("c2"), TeamColor.BLACK)).isTrue();
    }

    @Test
    @DisplayName("블랙의 경우 앞 방향인지 확인 - 실패")
    void isFront1() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isFront(Position.valueOf("c4"), TeamColor.BLACK)).isFalse();
    }

    @Test
    @DisplayName("화이트의 경우 앞 방향인지 확인")
    void isFront2() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isFront(Position.valueOf("c4"), TeamColor.WHITE)).isTrue();
    }

    @Test
    @DisplayName("화이트의 경우 앞 방향인지 확인 - 실패")
    void isFront3() {
        Position c3 = Position.valueOf("c3");
        assertThat(c3.isFront(Position.valueOf("c2"), TeamColor.WHITE)).isFalse();
    }

    @Test
    @DisplayName("위")
    void moveUp() {
        Position before = Position.valueOf("c3");

        Position after = before.moveUp();

        assertThat(after).isEqualTo(Position.valueOf("c4"));
    }

    @Test
    @DisplayName("아래")
    void moveDown() {
        Position before = Position.valueOf("c3");

        Position after = before.moveDown();

        assertThat(after).isEqualTo(Position.valueOf("c2"));
    }

    @Test
    @DisplayName("오른쪽")
    void moveRight() {
        Position before = Position.valueOf("c3");

        Position after = before.moveRight();

        assertThat(after).isEqualTo(Position.valueOf("d3"));
    }

    @Test
    @DisplayName("왼쪽")
    void moveLeft() {
        Position before = Position.valueOf("c3");

        Position after = before.moveLeft();

        assertThat(after).isEqualTo(Position.valueOf("b3"));
    }

    @Test
    @DisplayName("오른쪽 대각선 위")
    void moveRightUp() {
        Position before = Position.valueOf("c3");

        Position after = before.moveRightUp();

        assertThat(after).isEqualTo(Position.valueOf("d4"));
    }

    @Test
    @DisplayName("오른쪽 대각선 아래")
    void moveRightDown() {
        Position before = Position.valueOf("c3");

        Position after = before.moveRightDown();

        assertThat(after).isEqualTo(Position.valueOf("d2"));
    }

    @Test
    @DisplayName("왼쪽 대각선 위")
    void moveLeftUp() {
        Position before = Position.valueOf("c3");

        Position after = before.moveLeftUp();

        assertThat(after).isEqualTo(Position.valueOf("b4"));
    }

    @Test
    @DisplayName("왼쪽 대각선 아래")
    void moveLeftDown() {
        Position before = Position.valueOf("c3");

        Position after = before.moveLeftDown();

        assertThat(after).isEqualTo(Position.valueOf("b2"));
    }

    @Test
    @DisplayName("이동시 범위를 벗어나는 경우")
    void moveDown_fail() {
        Position before = Position.valueOf("a1");

        Position afterDown = before.moveDown();

        Position afterLeft = before.moveLeft();

        assertThat(afterDown).isEqualTo(Position.ERROR);
        assertThat(afterLeft).isEqualTo(Position.ERROR);
    }
}