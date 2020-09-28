package tp.pr1;

import java.util.Random;

public class Game {

	private Board _board;
	private int _size;
	private int _initCells;
	private Random _myRandom;
	private MoveResults rst;
	private int score;
	private int highest;
	private long seed;
		
	public Game(int size, int iniCells,long semilla) {
		// TODO Auto-generated constructor stub
		this.score=0;
		this.highest=0;
		this._size=size;
		this._initCells=iniCells;
		this.seed=semilla;
		Position[] pos;
		pos= new Position [size*size];
		Position posicion= new Position(0,0);
	
		
		_board = new Board(size);
		
		
		for(int i=0;i<iniCells;i++){
			
			llenar(semilla);
			System.out.println(_board.toString());
		}
	}

	public void move (Direction dir){
		rst= _board.executeMove(dir);
		score += rst.getScore();
		if( highest < rst.getHighest()){
			this.highest= rst.getHighest();
		}
		
	}
	
	public void reset (){	
		 _board = new Board(_size);
		 this.score=0;
		this.highest=0;
		
		
		for(int i=0;i<this._initCells;i++){
			
			llenar(this.seed);
			System.out.println(_board.toString());
		}
		
		
		
		System.out.println(_board);
	}
	public static void shuffle(Position[] list , Random random) {//baraja
		for (int i = list.length; i > 1; i--) {
			swap(list, i - 1, random.nextInt(i));
		}
		
	}
	
	// This method is static in order to be similar to the "shuffle () " method.
	public static Position choice(Position[] list, Random random) {//escoge
		return list[random.nextInt(list.length)];
	}
	private static void swap(Position[] anArray, int i, int j) {//intercambia posiciones , no sabemos pa queeeeeeee
		Position temp = anArray[i];
		anArray[i] = anArray[j];
		anArray[j] = temp;
	}
	public boolean isFinished(){
		boolean acabado =false;
		
		if(highest==2048 || !_board.canMerge()){
			acabado =true;
			if(highest == 2048){
				System.out.println("Has ganado :D");
			}
		}
		
		return acabado;
	}
	public String toString(){
		String hola="hola";
		System.out.println(_board);
		System.out.println("Score: "+ score);
		System.out.println(" Highest: "+ highest );
		System.out.println("\n");
		return hola;
	}
	
	public void llenar(long semilla){
		Position[] pos;
		pos= new Position [this._size*this._size];
		Position posicion= new Position(0,0);
		
		pos= _board.posicionLibres(_board.get_board());
		Random rand = new Random(semilla); 
		int num=new Random().nextInt(100);
		shuffle(pos,rand);
		posicion=choice(pos,rand);
		if(num<=9 ){
			_board.setCell(posicion, 4);
		}else _board.setCell(posicion, 2);
		System.out.println(_board);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
