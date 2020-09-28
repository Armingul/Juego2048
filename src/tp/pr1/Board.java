package tp.pr1;
import java.util.Random;
import java.util.Scanner;

import tp.pr1.Cell;

public class Board {

	
	private Cell [][] _board;
	private int _boardSize;
	
	public Board(int _boardSize) {
		
		this._boardSize=_boardSize;
		this._board=new Cell [_boardSize][_boardSize];
		for(int i=0;i<_boardSize;i++){
			for (int j=0;i<_boardSize;j++){
				this._board[i][j]=new Cell();
			}
		}
		
	}
	public void setCell(Position pos, int value){
		
		this._board[pos.getFila()][pos.getColumna()].setCell(value);
		
	}
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub

	}

	public MoveResults executeMove(Direction dir){
		return null; //Mirar esto
		
	
	
	}
	public String toString(){
		int cellSize=7;
		String space = " ";
		String vDelimiter = "|";
		String gDelimiter ="-";
		
		for(int i=0; i<this._board.length;i++){
			for(int j=0; j<this._board.length;j++){
				System.out.print("vDeLimiter"+this._board[i][j].getCell()+"vDeLimiter");
			}
			System.out.println();
		}
		return null; //no se que cojones quiere que devuelva
	
	}
	
	
	
	public void mover(){
		
		boolean movimiento=false;
		
		for(int i=0; i<_boardSize; i++){
			int ii = i +1;
			for(int j=0; j<_boardSize; j++){
				Cell celdaDeAhora = this._board[i][j];
				Cell celdaArriba = this._board[ii][j];
				if(celdaDeAhora.getCell() == celdaArriba.getCell()){
					if(celdaDeAhora.getCell() != 0 && celdaArriba.getCell() != 0){
						celdaArriba.incremento();
					}
					movimiento=true;
				}
				else if(celdaArriba.getCell()==0){
					this._board[ii][j]=celdaDeAhora;
					if(i>0) this._board[i][j] = this._board[i-1][j];
				}
			}
		}
		if(movimiento){
			this.generarNumero();
			
		}
	}
	
	public void generarNumero(){
		Random r=new Random();;
		int i = r.nextInt(this._board.length-1);
		
		Random r2=new Random();
		int j = r2.nextInt(this._board[i].length-1);
		this._board[i][j] = new Cell();
	}

}
