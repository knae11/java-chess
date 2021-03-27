package chess.domain.player;

import chess.domain.piece.*;
import chess.domain.pieceinformations.TeamColor;
import chess.domain.position.AlphaColumn;
import chess.domain.position.NumberRow;
import chess.domain.position.Position;

import java.util.*;
import java.util.stream.Collectors;

public class WhiteSet implements PieceSet {
    public static final String INITIAL_PAWN_LINE = "2";
    public static final int INITIAL_CAPACITY = 16;
    public static final double MINUS_HALF_POINT = -0.5;
    private static final TeamColor WHITE = TeamColor.WHITE;
    private final List<Piece> pieces;

    public WhiteSet() {
        this.pieces = new ArrayList<>(INITIAL_CAPACITY);
        initSet();
    }

    public WhiteSet(List<Piece> pieces) {
        this.pieces = pieces;
    }

    private void initSet() {
        setUniquePieces();
        setPawns();
    }

    private void setPawns() {
        for (AlphaColumn alphaColumn : AlphaColumn.values()) {
            NumberRow numberRow = NumberRow.valueOf(INITIAL_PAWN_LINE);
            pieces.add(new Pawn(TeamColor.WHITE, Position.valueOf(alphaColumn, numberRow)));

        }
    }

    private void setUniquePieces() {
        pieces.add(new Rook(WHITE, Position.valueOf("a1")));
        pieces.add(new Knight(WHITE, Position.valueOf("b1")));
        pieces.add(new Bishop(WHITE, Position.valueOf("c1")));
        pieces.add(new Queen(WHITE, Position.valueOf("d1")));
        pieces.add(new King(WHITE, Position.valueOf("e1")));
        pieces.add(new Bishop(WHITE, Position.valueOf("f1")));
        pieces.add(new Knight(WHITE, Position.valueOf("g1")));
        pieces.add(new Rook(WHITE, Position.valueOf("h1")));
    }

    @Override
    public Iterator<Piece> values() {
        return pieces.iterator();
    }

    @Override
    public Score calculateScore() {
        Score sum = Score.ZERO;
        Map<Character, Integer> pawnCount = new HashMap<>();

        for (Piece piece : alives()) {
            sum = sum.add(piece.getScore());
            recordPawns(pawnCount, piece);
        }

        return sum.add(subtractWhenOnSameLine(pawnCount));
    }

    private Score subtractWhenOnSameLine(Map<Character, Integer> pawnCount) {
        return pawnCount.values().stream()
                .filter(number -> number > 1)
                .map(number -> new Score(MINUS_HALF_POINT * number))
                .reduce(Score.ZERO, Score::add);
    }

    private List<Piece> alives() {
        return pieces.stream()
                .filter(Piece::isAlive)
                .collect(Collectors.toList());
    }

    private void recordPawns(Map<Character, Integer> pawnCount, Piece piece) {
        if (piece instanceof Pawn) {
            pawnCount.put(piece.getColumn(),
                    pawnCount.getOrDefault(piece.getColumn(), 0) + 1);
        }
    }

}
