package tp.pr1;
import java.lang.Math.*;   
public class Board {


	private Cell [][] _board;
	private int _boardSize;


	public Board(int _boardSize) {

		this._boardSize=_boardSize;
		this._board=new Cell [_boardSize][_boardSize];
		for(int i=0;i<_boardSize;i++){
			for (int j=0;j<_boardSize;j++){
				this._board[i][j] = new Cell();
			}
		}

	}


	public Cell[][] get_board() {
		return _board;
	}


	public void setCell(Position pos, int value){

		this._board[pos.getFila()][pos.getColumna()].setCell(value);

	}

	public MoveResults executeMove(Direction dir){

		MoveResults rst= new MoveResults();
		int pos=1;

		switch (dir) {

		case UP://Falta añadir el tema del score y el highest
			for(int i=0; i < _boardSize-1; i++){
				for(int j=0; j <= _boardSize-1; j++){
					
						if(!_board[i][j].isEmpty()){
							pos = buscarNum(i,j,dir);
							if(_board[i][j].doMerge(_board[pos][j])){
								rst.setScore((_board[i][j].getCell()));
							}
							
						}
						if(_board[i][j].getCell() > rst.getHighest()){
							rst.setHighest(_board[i][j].getCell());
						}
				}
			}
			
			for (int i =_boardSize-2; i>=0;i--){
				for(int j =_boardSize-1;j>=0;j--){
					if(_board[i][j].isEmpty()){
						for (int z=i;z<_boardSize-1;z++){
							_board[z][j].setCell(_board[z+1][j].getCell());
							_board[z+1][j].setCell(0);
						}
						
					}
				}
			}

			break;

		case DOWN:
			for (int i =_boardSize-1; i>=0;i--){
				for(int j =_boardSize-1;j>=0;j--){
					if(i>0){
						if(!_board[i][j].isEmpty()){
							pos = buscarNum(i,j,dir);
							if(_board[i][j].doMerge(_board[pos][j])){;
							rst.setScore((_board[i][j].getCell()));
							}
						}
					}
					if(_board[i][j].getCell() > rst.getHighest()){
						rst.setHighest(_board[i][j].getCell());
					}
				}
			}
			
			for (int i = 1; i <=_boardSize-1 ;i++){
				for(int j = 0;j<=_boardSize-1;j++){
					if(_board[i][j].isEmpty()){
						for (int z=i;z>0;z--){
							_board[z][j].setCell(_board[z-1][j].getCell());
							_board[z-1][j].setCell(0);
						}
						
					}
				}
			}

			break;
		case RIGHT:
			
			
			for(int j=_boardSize -1;j > 0; j--){
				for(int i=0; i <= _boardSize -1; i++){
					
					if(!_board[i][j].isEmpty()){
						pos = buscarNum(i,j,dir);
						
						if(_board[i][j].doMerge(_board[i][pos])){
						rst.setScore((_board[i][j].getCell()));
					}
						if(_board[i][j].getCell() > rst.getHighest()){
							rst.setHighest(_board[i][j].getCell());
					}
					
					}
				}
			}
			
			for(int j=1;j <= _boardSize-1;j++){
				for (int i=_boardSize -1;i>=0;i--){
					
					if(_board[i][j].isEmpty()){
						
						for (int z=j;z>0;z--){
							_board[i][z].setCell(_board[i][z-1].getCell());
							_board[i][z-1].setCell(0);
						}
						
						}
				}
			}
			
			
			
			break;
		case LEFT:
			
			for(int j=0;j < _boardSize-1; j++){
				for(int i=_boardSize -1; i >= 0; i--){

					if(!_board[i][j].isEmpty()){
						
						pos= buscarNum(i,j,dir);
						
							if(_board[i][j].doMerge(_board[i][pos])){
							rst.setScore((_board[i][j].getCell()));
							}
							if(_board[i][j].getCell() > rst.getHighest()){
								rst.setHighest(_board[i][j].getCell());
							}
					}
			
				}
			}
			
			for(int j=_boardSize -2;j >= 0; j--){
				for(int i=0; i < _boardSize -1; i++){
					if(_board[i][j].isEmpty()){
					
					for (int z=j;z<_boardSize -1;z++){
						_board[i][z].setCell(_board[i][z+1].getCell());
						_board[i][z+1].setCell(0);
					}
					}
				}
			}
					
			
			break;
		}
		String aux= toString();
		System.out.println(aux);
		return rst;		

	}
	
	
	public int buscarNum (int fila, int columna,Direction dir){
		int pos=fila;
		
		if(dir== dir.UP){
			pos=fila+1;
		while( _board[pos][columna].isEmpty() && pos < _boardSize -1){
			pos++;
		}
		}
		if(dir == dir.DOWN){
			pos= fila-1;
			while( _board[pos][columna].isEmpty() && pos > 0){
				pos--;
			}
		}
		if(dir == dir.RIGHT){
			pos=columna-1;
			while ( _board[fila][pos].isEmpty() && pos > 0){
				pos--;
			}
		}
		if(dir == dir.LEFT){
			pos=columna+1;
			while ( _board[fila][pos].isEmpty() && pos < _boardSize -1){
				pos++;
			}
			
		}
		
		
		
		return pos;
	}
	public String toString(){//switch 
		String myBoard = " ";

		int cellSize=7;
		String space = " ";
		String vDelimiter = "|";
		String gDelimiter ="-";

		for( int i=0; i<_boardSize;i++){
			myBoard =  myBoard + "\n";
			for (int j=0; j< _boardSize;j++){
				myBoard =  myBoard + "| "+ _board[i][j].getCell() + " |";

			}
		}
		//manana pregunto como hacemos esto.
		return myBoard;
	}
	public Position[] posicionLibres(Cell[][] tablero){
			
		Position[] posiciones;
		
		posiciones= new Position [(int) Math.pow(_boardSize, 2)];
		
		for (int i=0;i<(Math.pow(_boardSize, 2));i++){
			posiciones[i] = new Position(0,0);
		}
		
		
		
		
		int contador=0;
	
		for(int i=0;i<_boardSize;i++){
			for(int j=0;j<_boardSize;j++){
				
				if(tablero[i][j].isEmpty()){
					posiciones[contador].setFila(i);
					posiciones[contador].setColumna(j);
					contador++;
				}
			}
			
		}
		
		Position[] posicionBuena;
		posicionBuena = new Position [contador];
		
		for (int i=0;i<contador;i++){
			posicionBuena[i] = new Position(0,0);
		}
		for(int i=0;i<contador;i++){
			
			posicionBuena[i].setFila(posiciones[i].getFila());
			posicionBuena[i].setColumna(posiciones[i].getColumna());
		}
		
			
			return posicionBuena;
	}
	
	public boolean fullBoard(){
		boolean lleno=true;
		int contador=0;
		int i=0;
		int j=0;
		
		while (lleno && i < _boardSize){
			j=0;
			while (lleno && j<_boardSize){
			if( _board[i][j].isEmpty()){
				lleno=false;
			}else j++;
		}
			i++;
		}
		
		return lleno;
	}
	
	public boolean canMerge(){
		boolean noFusion=true;
		
		//falta comprobar del todo bien, pero funciona parcialmente. el boardSize -1 esta bien, simplemente 
		if(fullBoard()){
			for(int i=0;i<_boardSize-1;i++){
				for(int j=0;j<_boardSize-1;j++){
					if( (_board[i][j].getCell() != _board[i+1][j].getCell()) && (_board[i][j].getCell() != _board[i][j+1].getCell()) ){
						noFusion=false;
						i=_boardSize;
						j=_boardSize;
					}
				}
			}
		}
		
		return noFusion;
	}
	public static void main(String[] args) {


		Board tablero = new Board(5);
		MoveResults r= new MoveResults();

		
		tablero.setCell(new Position(0,0), 2);
		tablero.setCell(new Position(0,1), 2);
		tablero.setCell(new Position(0,3), 4);
		tablero.setCell(new Position(1,0), 2);
		tablero.setCell(new Position(1,1), 2);
		tablero.setCell(new Position(1,2), 4);
		tablero.setCell(new Position(1,3), 2);
		tablero.setCell(new Position(3,2), 2);
		tablero.setCell(new Position(3,1), 2);
		tablero.setCell(new Position(3,3), 2);
		tablero.setCell(new Position(0,2), 2);
		tablero.setCell(new Position(1,0), 2);
		System.out.println(tablero);
		
		r=tablero.executeMove(Direction.RIGHT);
		
		System.out.println(tablero);
		//r.setScore(tablero.executeMove(Direction.UP).getScore());
		//System.out.println(tablero);
		//System.out.print(r.getScore());
		r=tablero.executeMove(Direction.UP);
		System.out.print(r.getHighest());
	}
}
