package chess;
import java.util.*;

// King moves: using jump instead of slide, checks in each direction
public class KingMoves {
    public static Collection<ChessMove> calculate(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece
    ) {
        Collection<ChessMove> moves = new ArrayList<>();

        //use jump in MoveHelper
        MoveHelper.jump(board, start, piece, 1, 1, moves);
        MoveHelper.jump(board, start, piece, 0, 1, moves);
        MoveHelper.jump(board, start, piece, -1, 1, moves);
        MoveHelper.jump(board, start, piece, -1, 0, moves);
        MoveHelper.jump(board, start, piece, -1, -1, moves);
        MoveHelper.jump(board, start, piece, 0, -1, moves);
        MoveHelper.jump(board, start, piece, 1, -1, moves);
        MoveHelper.jump(board, start, piece, 1, 0, moves);

        return moves;
    }
}