package xadrez.backend.domain;

public class Piece {

	private String name,color;
	private int[] position;
	private int[][] moves;

	public Piece(String name,String color, int[] position, int[][] moves){
		setName(name);
		setColor(color);
		setPosition(position);
		setMoves(moves);	
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public int[] getPosition(){
		return this.position;
	}

	public void setPosition(int[] position){
		this.position = position;
	}

	public int[][] getMoves(){
		return this.moves;
	}

	public void setMoves(int[][] moves){
		this.moves = moves;
	}

}
