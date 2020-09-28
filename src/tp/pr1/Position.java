package tp.pr1;


public class Position {

	
	private int fila;
	private int columna;
	
	
	
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
	
	public boolean ValidarPosicion(int fila, int columna, int tamaño) { //Validan si la posicion esta dentro de tablero
		
		boolean booleano=false;
		
		if(fila<tamaño && columna<tamaño) {
			booleano=true;
			
		}
		return booleano;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
