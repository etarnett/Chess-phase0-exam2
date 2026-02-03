package chess;
import java.util.*;

/**  This file is used as a mediator between the ChessMove class and all
 * the different move classes used for each piece
**/
public class ChessMovesCalculator {
    public static Collection<ChessMove> calculateMoves (
            ChessBoard board,
            ChessPosition position
    ) {
        Collection<ChessMove> moves = new ArrayList<>();

        ChessPiece piece = board.getPiece(position);
        if (piece == null) {
            return null;
        }

        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            return BishopMoves.calculate(board, position, piece);
        }

        if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            return RookMoves.calculate(board, position, piece);
        }

        if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            return QueenMoves.calculate(board, position, piece);
        }

        if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            return KingMoves.calculate(board, position, piece);
        }

        if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            return KnightMoves.calculate(board, position, piece);
        }


        return moves;
    }
}
