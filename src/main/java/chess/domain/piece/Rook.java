package chess.domain.piece;

import chess.domain.pieceinformations.PieceInformation;
import chess.domain.pieceinformations.State;
import chess.domain.pieceinformations.TeamColor;
import chess.domain.position.Position;

import java.util.Map;
import java.util.Set;

public class Rook extends PieceOnBoard {
    public Rook(TeamColor teamColor) {
        super(teamColor, PieceInformation.ROOK);
    }

    public Rook(TeamColor teamColor, State state) {
        super(teamColor, PieceInformation.BISHOP, state);
    }

    @Override
    public boolean isMovable(Position source, Position target, Map<Position, Piece> chessBoard) {
        Set<Position> candidates = moveCrossAsPossible(source, target, chessBoard);
        return candidates.contains(target);
    }

}