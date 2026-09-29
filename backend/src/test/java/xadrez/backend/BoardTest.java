package xadrez.backend.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;
import java.util.stream.Stream;

class BoardTest {

	private Board board;

	@Test
	void rookMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("rook","white",i,PieceMoves.ROOK));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.ROOK)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}
	}

	@Test
	void bishopMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("bishop","white",i,PieceMoves.BISHOP));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.BISHOP)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}
	}
	@Test
	void queenMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("queen","white",i,PieceMoves.QUEEN));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.QUEEN)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}
	}

	@Test
	void horseMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("horse","white",i,PieceMoves.HORSE));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.HORSE)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}

	}

	@Test
	void kingMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("king","white",i,PieceMoves.KING));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.KING)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}

	}

	@Test
	void pawnMovement() {
		for(int i = 1; i < 65; i++){
			for(int j = 1; j < 65; j++){
				Board board = new Board(new Piece("pawn","white",i,PieceMoves.PAWN));
				int requiredPos = j,initialPos = i;
				board.movePiece(requiredPos);
				System.out.println("----------------------------------");
				System.out.println(requiredPos);
				System.out.println(board.pieces.get(0).getPosition());
				System.out.println("----------------------------------");
				if(i != j){
					//System.out.println(requiredPos - board.pieces.get(0).getPosition());
					System.out.println(board.pieces.get(0).getPosition() == requiredPos);
					if(Arrays.stream(PieceMoves.PAWN)
					   .anyMatch(pos -> pos == requiredPos - initialPos))
						assertTrue(board.pieces.get(0).getPosition() == requiredPos);
					else
						assertFalse(board.pieces.get(0).getPosition() == requiredPos);
				}
			}
		}

	}

}
