package chess;
import java.util.*;

//implementing the Rook Slide calculation
public class RookMoves {
    public static Collection<ChessMove> calculate(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece
    ) {
        Collection<ChessMove> moves = new ArrayList<>();

        //use helper function to write a sliding move helper
        MoveHelper.slide(board, start, piece, 1, 0, moves);
        MoveHelper.slide(board, start, piece, 0, 1, moves);
        MoveHelper.slide(board, start, piece, -1, 0, moves);
        MoveHelper.slide(board, start, piece, 0, -1, moves);


        return moves;
    }
}
