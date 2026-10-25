package xadrez.backend.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.HashMap;

public class Board{
	
	public HashMap<Integer,Character> pieces = new HashMap<>();

	public boolean whiteTurn = true;
	int whiteEnPassant = 0, blackEnPassant = 0;
	public Board(HashMap<Integer,Character> pieces){
		this.pieces = pieces;
	}

	void updateBoard(){
		if(whiteTurn){
			if(pieces.get(blackEnPassant) != null)
		  		pieces.put(blackEnPassant,'P');
			whiteTurn = false;
		}
		else{
			if(pieces.get(whiteEnPassant) != null)
				pieces.put(whiteEnPassant,'p');
			whiteTurn = true;
		}
		
	}

	String movePiece(int piecePos,int destination){
		if(pieces.get(piecePos) != null){
			if((Character.isLowerCase(pieces.get(piecePos)) && whiteTurn) || (Character.isUpperCase(pieces.get(piecePos)) && !whiteTurn)){
				if(pieces.get(piecePos) != null && destination > 0 && destination < 65){
						if(pieces.get(destination) == null ||
							     (Character.isUpperCase(pieces.get(destination)) && !Character.isUpperCase(pieces.get(piecePos))) ||
							     (!Character.isUpperCase(pieces.get(destination)) && Character.isUpperCase(pieces.get(piecePos)))){
							if (Character.toLowerCase(pieces.get(piecePos)) == 'p'){
								if(pawnLogic(piecePos,destination)){
									updateBoard();
									return "Movimento aprovado";
								}
							}
							if(Arrays.stream(PieceMoves.getMoves(pieces.get(piecePos)))
								.anyMatch(pos -> pos == destination - piecePos)){
								if(pieceInTheWay(piecePos,destination)){
									return "Peça no caminho";
								}
								pieces.put(destination,pieces.get(piecePos));
								pieces.remove(piecePos);
								updateBoard();
								return "Movimento aprovado";
							}
						}
						else{
							return "Espaço ocupado";	
						}

				}
				return "Movimento ilegal";
			}
			else{
				return "Você selecionou a peça de seu adversário, tente novamente";
			}
		}
		else
			return "Não tem peça nesse quadrado, tente novamente";
	}

	boolean pawnLogic(int piecePos, int destination){
		   int modifier = 1;
		   if(pieces.get(piecePos) == 'P'){
			   modifier = -1;
			   if(piecePos >  48 && destination == piecePos - 16 && pieces.get(destination + 8 ) == null && pieces.get(destination) == null){
				pieces.put(destination,'E'); 
				blackEnPassant = destination;
				pieces.remove(piecePos);
				return true;
			   }

			   if(pieces.get(piecePos - 1) != null || pieces.get(piecePos - 1) != null && (destination == piecePos - 9 || destination == piecePos - 7)){
				   	pieces.put(destination,'P');
					pieces.remove(piecePos);
					if(pieces.get(piecePos - 1) != null && pieces.get(piecePos - 1) == 'e')
						pieces.remove(piecePos - 1);
					else if(pieces.get(piecePos + 1) != null && pieces.get(piecePos + 1) == 'e')
						pieces.remove(piecePos + 1);
					return true;
			   }
	

		   }
		   else {
			   if(piecePos < 17 && destination == piecePos + 16 && pieces.get(destination - 8) == null && pieces.get(destination) == null){
				pieces.put(destination,'e'); 
				whiteEnPassant = destination;
				pieces.remove(piecePos);
				return true;
			   }
			   if(pieces.get(piecePos - 1) != null || pieces.get(piecePos - 1) != null && (destination == piecePos - 9 || destination == piecePos - 7)){
				   	pieces.put(destination,'P');
					pieces.remove(piecePos);
					if(pieces.get(piecePos - 1) != null && pieces.get(piecePos - 1) == 'e')
						pieces.remove(piecePos - 1);
					else if(pieces.get(piecePos + 1) != null && pieces.get(piecePos + 1) == 'e')
						pieces.remove(piecePos + 1);
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
