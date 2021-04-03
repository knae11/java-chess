package chess.domain.piece;

import chess.domain.pieceinformations.PieceInformation;
import chess.domain.pieceinformations.State;
import chess.domain.pieceinformations.TeamColor;
import chess.domain.position.Moves;
import chess.domain.position.Position;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Knight extends PieceOnBoard {

    public Knight(TeamColor teamColor) {
        super(teamColor, PieceInformation.KNIGHT);
    }

    public Knight(TeamColor teamColor, Position position) {
        super(teamColor, PieceInformation.KNIGHT, position);
    }

    public Knight(TeamColor teamColor, Position position, State state) {
        super(teamColor, PieceInformation.KNIGHT, position, state);
    }

    @Override
    public boolean isMovable(Position target, Map<Position, Piece> chessBoard) {
        final Set<Position> candidates = new HashSet<>();

        candidates.add(moveOnce(Moves.LEFT_DOWN_DOWN, target, chessBoard));
        candidates.add(moveOnce(Moves.LEFT_UP_LEFT, target, chessBoard));
        candidates.add(moveOnce(Moves.LEFT_DOWN_LEFT, target, chessBoard));
        candidates.add(moveOnce(Moves.LEFT_UP_UP, target, chessBoard));
        candidates.add(moveOnce(Moves.RIGHT_DOWN_DOWN, target, chessBoard));
        candidates.add(moveOnce(Moves.RIGHT_DOWN_RIGHT, target, chessBoard));
        candidates.add(moveOnce(Moves.RIGHT_UP_RIGHT, target, chessBoard));
        candidates.add(moveOnce(Moves.RIGHT_UP_UP, target, chessBoard));

        return candidates.contains(target);
    }

}
