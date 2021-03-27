package chess.domain.piece;

import chess.domain.pieceinformations.PieceInformation;
import chess.domain.pieceinformations.TeamColor;
import chess.domain.position.Moves;
import chess.domain.position.Position;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bishop extends PieceOnBoard {

    public Bishop(TeamColor teamColor) {
        super(teamColor, PieceInformation.BISHOP);
    }

    public Bishop(TeamColor teamColor, Position position) {
        super(teamColor, PieceInformation.BISHOP, position);
    }

    @Override
    public boolean isMoveAble(Position target, Map<Position, Piece> chessBoard) {
        final Set<Position> candidates = moveDiagonalAsPossible(target, chessBoard);
        return candidates.contains(target);
    }


}
