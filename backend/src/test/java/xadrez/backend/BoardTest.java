package xadrez.backend.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.HashMap;

class BoardTest {

	private Board board;
	
	@Test
	void validateMovement(){
		HashMap<Integer,Character> pieces = new HashMap<>();
		pieces.put(1,'r');
		pieces.put(2,'h');
		pieces.put(3,'b');
		pieces.put(4,'k');
		pieces.put(5,'q');
		pieces.put(6,'b');
		pieces.put(7,'h');
		pieces.put(8,'r');
		pieces.put(9,'p');
		pieces.put(10,'p');
		pieces.put(11,'p');
		pieces.put(12,'p');
		pieces.put(13,'p');
		pieces.put(14,'p');
		pieces.put(15,'p');
		pieces.put(16,'p');

		pieces.put(64,'R');
		pieces.put(63,'H');
		pieces.put(62,'B');
		pieces.put(61,'K');
		pieces.put(60,'Q');
		pieces.put(59,'B');
		pieces.put(58,'H');
		pieces.put(57,'R');
		pieces.put(56,'P');
		pieces.put(55,'P');
		pieces.put(54,'P');
		pieces.put(53,'P');
		pieces.put(52,'P');
		pieces.put(51,'P');
		pieces.put(50,'P');
		pieces.put(49,'P');

		Board board = new Board(pieces);
		assertEquals("Movimento aprovado",board.movePiece(12,20));

	}

	@Test
	void validateMovementB(){
		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(8,'r');
			pieces.put(48 - i * 8,'p');

			Board board = new Board(pieces);
			assertEquals("Espaço ocupadoB",board.movePiece(8,56));
		}

		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(64,'r');
			pieces.put(16 + i * 8,'p');

			Board board = new Board(pieces);
			assertEquals("Espaço ocupadoB",board.movePiece(64,8));
		}

		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(16,'r');
			System.out.println(10 + i);
			pieces.put(10 + i,'p');

			Board board = new Board(pieces);
			assertEquals("Espaço ocupadoB",board.movePiece(16,9));
		}
		System.out.println("-------------------------------------");
		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(9,'r');
			System.out.println(10 + i);
			pieces.put(15 - i,'p');

			Board board = new Board(pieces);
			System.out.println(9 + PieceMoves.getMoves(pieces.get(9))[i]);
			System.out.println(board.pieces.get(9 + PieceMoves.getMoves(board.pieces.get(9))[i]));
			System.out.println(board.pieces.get(16));
			assertEquals("Espaço ocupadoB",board.movePiece(9,16));
		}

	}

	@Test
	void validateMovementC(){
		HashMap<Integer,Character> pieces = new HashMap<>();
		pieces.put(8,'r');

		pieces.put(48,'p');

		Board board = new Board(pieces);
		assertEquals("Espaço ocupado",board.movePiece(8,48));

	}

	@Test
	void validateMovementD(){
		for(int i = 0; i < 6; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(8,'r');

			pieces.put(16 + i * 8,'P');

			Board board = new Board(pieces);
			assertEquals("Movimento aprovado",board.movePiece(8,16 + i * 8));
		}

		for(int i = 0; i < 6; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(64,'r');

			pieces.put(56 - i * 8,'P');

			Board board = new Board(pieces);
			assertEquals("Movimento aprovado",board.movePiece(64,56 - i * 8));
		}

		for(int i = 0; i < 6; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(16,'r');

			pieces.put(9 + i,'P');

			Board board = new Board(pieces);
			assertEquals("Movimento aprovado",board.movePiece(16,9+i));
		}

		for(int i = 0; i < 6; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(9,'r');

			pieces.put(10 + i,'P');

			Board board = new Board(pieces);
			assertEquals("Movimento aprovado",board.movePiece(9,10+i));
		}

	}

}
