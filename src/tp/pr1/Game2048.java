package tp.pr1;

import java.util.Random;

 
public class Game2048 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		long seed;
		int size = Integer.parseInt(args[0]);
		int iniCells = Integer.parseInt(args[1]);
		seed = Long.parseLong(args[2]); // Si hay un tercer argumento
		
		//Game juego = new Game(size,iniCells,seed);
	
		Controller controlador= new Controller ( size,  iniCells, seed);
		controlador.run();
	}

}
