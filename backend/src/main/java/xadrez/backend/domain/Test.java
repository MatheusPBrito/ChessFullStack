//this class is temporary, it'll be used for testing the chess logic before engage with the spring boot logic
package xadrez.backend.domain;

import java.util.Scanner;

public class Test{
	public static void main(String[] args){
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		int x = 0, y = 0;

		while(true){
			System.out.println("Digite a posição para peça se mover");
			System.out.print("x: ");
			if(scanner.hasNextInt()){
				x = scanner.nextInt();
			}
			System.out.print("y: ");
			if(scanner.hasNextInt()){
				y = scanner.nextInt();
			}
			System.out.println();
			board.movePiece(x,y);
		}

	}

}
