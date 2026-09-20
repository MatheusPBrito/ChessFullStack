package xadrez.backend.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Board{
	
	private final int MINX = 1, MAXX = 8, MINY = 1, MAXY = 8;

	List<Piece> pieces = new ArrayList<>();

	public Board(){
		pieces.add(new Piece("bishop","white",new int[] {1,1},PieceMoves.BISHOP));
	}


	void movePiece(int x, int y){
		if((x <= 8 && x > 0) && (y <= 8 && y > 0)){
			if(Arrays.stream(pieces.get(0).getMoves())
			   .anyMatch(array -> 
		            Arrays.equals(array,new int[] {x - pieces.get(0).getPosition()[0], y - pieces.get(0).getPosition()[1]}))){
				pieces.get(0).setPosition(new int[]{x,y});
				System.out.println("Agora a posição é x: " + pieces.get(0).getPosition()[0] + " y: " + pieces.get(0).getPosition()[1]);
			}
			else{
				System.out.println("Movimento invalido!");
			}
		}	
		else{
			System.out.println("Essa posição está fora do tabuleiro");
		}
	}

	void castle(){

	}	
}
