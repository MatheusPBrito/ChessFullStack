package xadrez.backend.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.HashMap;

public class Board{
	
	public HashMap<Integer,Character> pieces = new HashMap<>();

	public Board(HashMap<Integer,Character> pieces){
		this.pieces = pieces;
	}


	String movePiece(int piecePos,int destination){
		if(pieces.get(piecePos) != null && destination > 0 && destination < 65){
				if(pieces.get(destination) == null ||
					     (Character.isUpperCase(pieces.get(destination)) && !Character.isUpperCase(pieces.get(piecePos))) ||
					     (!Character.isUpperCase(pieces.get(destination)) && Character.isUpperCase(pieces.get(piecePos)))){
					if(Arrays.stream(PieceMoves.getMoves(pieces.get(piecePos)))
						.anyMatch(pos -> pos == destination - piecePos)){
						if(pieces.get(piecePos) == 'r' || 
						   pieces.get(piecePos) == 'b' ||
						   pieces.get(piecePos) == 'q'){
							int moveIndex = 0;
						  	for(int i = 0; i < PieceMoves.getMoves(pieces.get(piecePos)).length;i++){
								if(PieceMoves.getMoves(pieces.get(piecePos))[i] == destination-piecePos){
									moveIndex = i;
									break;
								}
							}
							int initialIndex = moveIndex;

							if(initialIndex > 6){
								while(initialIndex > 6){
									initialIndex -= 6;	
								}
							}
							else
								initialIndex = 0;
							
							for(int i = initialIndex; i < moveIndex; i++){
								if(pieces.get(piecePos + PieceMoves.getMoves(pieces.get(piecePos))[i]) != null){
									return "Espaço ocupadoB";	
								}
							}
						   }
						pieces.put(destination,pieces.get(piecePos));
						pieces.remove(piecePos);
						return "Movimento aprovado";
					}
				}
				else{
					return "Espaço ocupado";	
				}

		}
		return "Movimento ilegal";
	}
}
