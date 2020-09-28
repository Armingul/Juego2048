package tp.pr1;

public class Position {

	
	private int fila;
	private int columna;
	
	public Position(int fila, int columna) {
		this.fila= fila;
		this.columna= columna;
	}
	
	public int getFila(){
		
		return this.fila;
	}
	
	public int getColumna(){
		
		return this.columna;
	}
	
	public  void setColumna(int c){
		this.columna = c;
	}
	
	public void setFila(int f){
		this.fila = f;
	}
	
	public boolean ValidarPosicion(int fila, int columna, int tamano) { //Validan si la posicion esta dentro de tablero
		//RECORDAR LUEGO PASARLE TAM-1 POR SI EL USUARIO METE FILAS TAL CUAL.
		boolean booleano=false;
		
		if(fila<tamano && columna<tamano) {
			booleano=true;
			
		}
		return booleano;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
