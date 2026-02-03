package chess;
import java.util.*;

//implementing the Queen Slide moves
public class QueenMoves {
    public static Collection<ChessMove> calculate(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece
    ) {
        Collection<ChessMove> moves = new ArrayList<>();

        //Bishop moves
        MoveHelper.slide(board, start, piece, 1, 1, moves);
        MoveHelper.slide(board, start, piece, 1, -1, moves);
        MoveHelper.slide(board, start, piece, -1, 1, moves);
        MoveHelper.slide(board, start, piece, -1, -1, moves);

        //Rook moves
        MoveHelper.slide(board, start, piece, 1, 0, moves);
        MoveHelper.slide(board, start, piece, 0, 1, moves);
        MoveHelper.slide(board, start, piece, -1, 0, moves);
        MoveHelper.slide(board, start, piece, 0, -1, moves);


        return moves;
    }
}
