package xadrez.backend.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Board{
	
	private final int MINX = 1, MAXX = 8, MINY = 1, MAXY = 8;

	//this variable is public for the mean time just for testing, it should be private soon
	public List<Piece> pieces = new ArrayList<>();

	public Board(Piece piece){
		pieces.add(piece);
	}


	void movePiece(int square){
		if(square > 0 && square < 65){
			if(Arrays.stream(pieces.get(0).getMoves())
			.anyMatch(pos -> pos == square - pieces.get(0).getPosition()))	
				pieces.get(0).setPosition(square);
		}
	}
}
