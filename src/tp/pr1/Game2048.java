package tp.pr1;
import java.util.Random;

public class Game2048 {
	
	private Board _board;
	private int _size;
	private int _initCells;
	private Random _myRandom;
	private int score;
	private boolean finalizada;
	private int max;
	
	public  Game2048(int dimension, int baldosasIniciales, Random random){
		
		this._size=dimension; 
		this._initCells=baldosasIniciales;
		this._myRandom=random;
		
	}
	

	public static void main(String[] args) {
		

	}
	 public void move(Direction dir){

			
			if(dir == Direction.UP){
				
			}
			if(dir == Direction.DOWN){
				
				
			}
			if(dir == Direction.LEFT){
				
			}
			if(dir == Direction.RIGHT){
				
			}
			
			
			
			
		 
	 }


	public Board get_board() {
		return _board;
	}


	public void set_board(Board _board) {
		this._board = _board;
	}


	public int get_size() {
		return _size;
	}


	public void set_size(int _size) {
		this._size = _size;
	}


	public int get_initCells() {
		return _initCells;
	}


	public void set_initCells(int _initCells) {
		this._initCells = _initCells;
	}


	public Random get_myRandom() {
		return _myRandom;
	}


	public void set_myRandom(Random _myRandom) {
		this._myRandom = _myRandom;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public boolean isFinalizada() {
		return finalizada;
	}


	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}



	
	
	
}
