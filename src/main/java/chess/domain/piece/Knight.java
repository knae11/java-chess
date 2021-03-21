package chess.domain.piece;

import chess.domain.ChessBoard;
import chess.domain.position.Position;
import chess.domain.TeamColor;
import java.util.HashSet;
import java.util.Set;

public class Knight extends PieceOnBoard {

    public Knight(TeamColor teamColor) {
        super(teamColor, PieceInformation.KNIGHT);
    }

    public Knight(TeamColor teamColor, Position position) {
        super(teamColor, PieceInformation.KNIGHT, position);
    }

    @Override
    public boolean isMoveAble(Position source, Position target, ChessBoard chessBoard) {

        Set<Position> candidates = new HashSet<>();

        Position position = source.moveRightUp().moveUp();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }
        position = source.moveRightUp().moveRight();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }

        position = source.moveRightDown().moveRight();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }
        position = source.moveRightDown().moveDown();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }

        position = source.moveLeftDown().moveDown();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }
        position = source.moveLeftDown().moveLeft();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }

        position = source.moveLeftUp().moveLeft();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }
        position = source.moveLeftUp().moveUp();
        if (position != Position.ERROR && chessBoard.isBlank(position) ||
            (position == target && isEnemyTeam(chessBoard.getPiece(position)))) {
            candidates.add(position);
        }

        return candidates.contains(target);
    }

}
