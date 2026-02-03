package chess;
import java.util.*;

public class MoveHelper {

    // move for sliding pieces like Queen, Bishop, and Rook
    public static void slide(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece,
            int rowDir,
            int colDir,
            Collection<ChessMove> moves
    ) {
        int row = start.getRow() + rowDir;
        int col = start.getColumn() + colDir;

        //while still in bounds
        while (row >= 1 && row <= 8 && col >= 1 && col <= 8) {
            //check new possible square and see if there is piece
            ChessPosition end = new ChessPosition(row,col);
            ChessPiece target = board.getPiece(end);

            //if space is empty, add
            if (target == null) {
                moves.add(new ChessMove(start, end, null));
            }
            //if target is enemy team piece, add
            else {
                if (target.getTeamColor() != piece.getTeamColor()) {
                    moves.add(new ChessMove(start, end, null));
                }
                break;
            }

            //increment
            row += rowDir;
            col += colDir;
        }
    }

    //move for King and Knight, single direction
    public static void jump(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece,
            int rowDir,
            int colDir,
            Collection<ChessMove> moves
    ) {
        return;
    }
}
