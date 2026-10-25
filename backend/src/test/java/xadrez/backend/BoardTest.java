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
	void validateMovementB(){
		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(8,'r');
			pieces.put(48 - i * 8,'p');

			Board board = new Board(pieces);
			assertEquals("Peça no caminho",board.movePiece(8,56));
		}

		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(64,'r');
			pieces.put(16 + i * 8,'p');

			Board board = new Board(pieces);
			assertEquals("Peça no caminho",board.movePiece(64,8));
		}

		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(16,'r');
			pieces.put(10 + i,'p');

			Board board = new Board(pieces);
			assertEquals("Peça no caminho",board.movePiece(16,9));
		}
		for(int i = 0; i < 5; i++){
			HashMap<Integer,Character> pieces = new HashMap<>();
			pieces.put(9,'r');
			pieces.put(15 - i,'p');

			Board board = new Board(pieces);
			assertEquals("Peça no caminho",board.movePiece(9,16));
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

	@Test
	void enPassant(){
		HashMap<Integer,Character> pieces = new HashMap<>();
		pieces.put(10,'p');
		pieces.put(27,'P');

		Board board = new Board(pieces);
		assertEquals(true,board.whiteTurn);
		assertEquals("Movimento aprovado", board.movePiece(10,26));
		assertEquals('e',pieces.get(26));
		assertEquals(false,board.whiteTurn);
		assertEquals("Movimento aprovado",board.movePiece(27,18));
		assertEquals(null,pieces.get(26));
		assertEquals(null,pieces.get(27));
		assertEquals('P',pieces.get(18));
	}

}
