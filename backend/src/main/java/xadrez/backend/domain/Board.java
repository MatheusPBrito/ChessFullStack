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
		   			if (Character.toLowerCase(pieces.get(piecePos)) == 'p'){
						if(pawnLogic(piecePos,destination))
							return "Movimento aprovado";
					}
					if(Arrays.stream(PieceMoves.getMoves(pieces.get(piecePos)))
						.anyMatch(pos -> pos == destination - piecePos)){
						if(pieceInTheWay(piecePos,destination)){
							return "Peça no caminho";
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

	boolean pawnLogic(int piecePos, int destination){
		   int modifier = 1;
		   if(pieces.get(piecePos) == 'P'){
			   modifier = -1;
			   if(piecePos >  48 && destination == piecePos - 16 && pieces.get(destination + 8 ) == null && pieces.get(destination) == null){
				pieces.put(destination,pieces.get(piecePos)); 
				pieces.remove(piecePos);
				return true;
			   }

			   if(destination == piecePos - 9 || destination == piecePos - 7){
				if((pieces.get(destination) != null && Character.isLowerCase(pieces.get(destination)))){
					pieces.put(destination,pieces.get(piecePos)); 
					pieces.remove(piecePos);
					return true;
				}
			   }
		   }

		   if(piecePos < 17 && destination == piecePos + 16 && pieces.get(destination - 8) == null && pieces.get(destination) == null){
			pieces.put(destination,pieces.get(piecePos)); 
			pieces.remove(piecePos);
			return true;
		   }
		   if(destination == piecePos + 9 || destination == piecePos + 7){
			if((pieces.get(destination) != null && Character.isUpperCase(pieces.get(destination)))){
				pieces.put(destination,pieces.get(piecePos)); 
				pieces.remove(piecePos);
				return true;
			}
		   }

		   if (destination == piecePos + 8 * modifier){
				pieces.put(destination,pieces.get(piecePos)); 
				pieces.remove(piecePos);
				return true;
		   }
		   else
			   return false;


	}

	boolean pieceInTheWay(int piecePos, int destination){
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
					return true;	
				}
			}
		}
		return false;
	}
}
