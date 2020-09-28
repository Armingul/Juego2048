package tp.pr1;
import java.util.Random;


public class Cell {

	
	private int celda;
	
	
	
	public  Cell() { //constructora por defecto
		Random dosocuatro = new Random();
		
		 this.celda = (dosocuatro.nextInt(2)+1)*2;
	}
	 public Cell (int valorAMeter){
		 this.celda=valorAMeter;
	 }
	
	public int  getCell(){
		
		return this.celda;
		
	}
	
	
	 public  void setCell(int valor){
		
		this.celda=valor;
		
	}
	
	
	 
	public boolean isEmpty(){
		
		boolean vacia=false;
		if (this.celda == 0 ){
			vacia=true;
			
		}
		
		return vacia;
	}
	
	public boolean doMerge (Cell neighbour){
		
		boolean fusion=false;
		
		if(this.celda== neighbour.getCell() ){
			fusion=true;
			this.celda= this.celda + neighbour.getCell();
			neighbour.setCell(0);
			
		}
		
		
		return fusion;
	}
	
	public int incremento(){
		
		return this.celda*=2;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
