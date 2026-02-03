package chess;
import java.util.*;

// King moves: using jump instead of slide, checks in each direction
public class KnightMoves {
    public static Collection<ChessMove> calculate(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece
    ) {
        Collection<ChessMove> moves = new ArrayList<>();

        //use jump in MoveHelper
        MoveHelper.jump(board, start, piece, 2, 1, moves);
        MoveHelper.jump(board, start, piece, 2, -1, moves);
        MoveHelper.jump(board, start, piece, -2, 1, moves);
        MoveHelper.jump(board, start, piece, -2, -1, moves);
        MoveHelper.jump(board, start, piece, 1, 2, moves);
        MoveHelper.jump(board, start, piece, -1, 2, moves);
        MoveHelper.jump(board, start, piece, 1, -2, moves);
        MoveHelper.jump(board, start, piece, -1, -2, moves);


        return moves;
    }


}