package chess;

import chess.domain.ChessBoard;
import chess.view.Commands;
import chess.view.InputView;
import chess.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printInitMessage();
        final ChessBoard chessBoard = new ChessBoard();
        while (chessBoard.isPlaying()) {
            List<String> command = InputView.command();
            if (Commands.getInstance(command.get(0)) == Commands.START) {
                OutputView.printBoard(chessBoard.getChessBoard());
            }
            if (Commands.getInstance(command.get(0)) == Commands.MOVE) {
                chessBoard.move(command.get(1), command.get(2));
                OutputView.printBoard(chessBoard.getChessBoard());
            }
            if (Commands.getInstance(command.get(0)) == Commands.STATUS) {
                OutputView.printScore(chessBoard.result());
            }
            if (Commands.getInstance(command.get(0)) == Commands.END) {
                return;
            }
        }
        OutputView.printScore(chessBoard.result());
    }


}
