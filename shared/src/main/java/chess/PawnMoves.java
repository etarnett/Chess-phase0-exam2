package chess;
import java.util.*;

// Pawn moves: move forward 1, move forward 2 if on starting position, attack right and left
// if there is an enemy piece, promotion zone allows pawn to promote to Queen, Rook, or Bishop
public class PawnMoves {
    public static Collection<ChessMove> calculate(
            ChessBoard board,
            ChessPosition start,
            ChessPiece piece
    ) {
        Collection<ChessMove> moves = new ArrayList<>();
        //find position
        int row = start.getRow();
        int col = start.getColumn();

        //distinguish between white and black: direction, startRow, promotionRow
        int direction;
        int startRow;
        int promotionRow;
        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            direction = 1;
            startRow = 2;
            promotionRow = 8;
        } else {
            direction = -1;
            startRow = 7;
            promotionRow = 1;
        }

        ChessPosition advance = new ChessPosition(row + direction, col);
        if (MoveHelper.inBounds(row+direction, col) && board.getPiece(advance) == null) {
            MoveHelper.promotion(start, advance, promotionRow, moves);

            //check if on startRow
            if (row == startRow) {
                ChessPosition advanceTwo = new ChessPosition(row + (direction*2), col);
                if (board.getPiece(advanceTwo) == null) {
                    moves.add(new ChessMove(start, advanceTwo, null));
                }
            }
        }

        //implement capture on either side
        //left side attack check
        if (MoveHelper.inBounds(row + direction, col -1)) {
            ChessPosition leftAttack = new ChessPosition(row + direction, col -1);
            ChessPiece target = board.getPiece(leftAttack);

            //see if there is an enemy piece on left attack
            if (target != null && target.getTeamColor() != piece.getTeamColor()) {
                MoveHelper.promotion(start, leftAttack, promotionRow, moves);
            }
        }

        //right side attack check
        if (MoveHelper.inBounds(row + direction, col + 1)) {
            ChessPosition rightAttack = new ChessPosition(row + direction, col +1);
            ChessPiece target = board.getPiece(rightAttack);

            //see if there is an enemy piece on left attack
            if (target != null && target.getTeamColor() != piece.getTeamColor()) {
                MoveHelper.promotion(start, rightAttack, promotionRow, moves);
            }
        }



        return moves;
    }
}