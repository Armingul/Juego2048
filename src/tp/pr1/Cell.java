package tp.pr1;

public class Cell {

	
	private int cell;
	
	public Cell() {
		this.cell=0;
	}

	
	public int  getCell(){
		
		return this.cell;
		
	}
	
	
	 public void setCell(int valor){
		
		this.cell=valor;
		
	}
	
	 
	public boolean isEmpty(){
		
		boolean vacia=false;
		
		if (this.cell == 0 ){
			vacia=true;
			
		}
		
		return vacia;
	}
	
	public boolean doMerge (Cell neighbour){
		
		boolean fusion=false;
		
		if(this.cell== neighbour.getCell() ){
			fusion=true;
			this.cell= this.cell + neighbour.getCell();
			neighbour.setCell(0);
			
		}
		
		
		return fusion;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
