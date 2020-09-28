package tp.pr1;
import java.util.*;
public class Controller {

	private Game game;
	private Scanner in;
	private long seed;
	public Controller(int size, int iniCells, long seed) {

	game = new Game(size,iniCells,seed);
	this.seed=seed;

	}
	public void run(){

	

		String teclado;
		String aux;
		do{
			
			Scanner sc=new Scanner(System.in);
			teclado = sc.nextLine();
			
			switch(teclado){
			case "move up":
				game.move(Direction.UP);
				game.llenar(this.seed);
				break;
			case "move down":
				game.move(Direction.DOWN);
				game.llenar(this.seed);
				break;
			case "move right":
				game.move(Direction.RIGHT);
				game.llenar(this.seed);
				break;
			case "move left":
				game.move(Direction.LEFT);
				game.llenar(this.seed);
				break;
			case "help" :
				ayuda();
				break;
			case "reset" :
				game.reset();
				break;
			default: break;
			
			//aux = game.toString();
			}
			if(game.isFinished()){
				System.out.println("Game over. /n");
			}
		}while (teclado != "exit" && !game.isFinished());
			
			

			


		
		//controlar si es help, move etc y hacer las llamadas pertinentes


	}

	public static void ayuda(){
		System.out.println("Instrucciones para jugar al 2048: \n");
		System.out.println("1. El objetivo es llegar a tener una celda 2048 \n");
		System.out.println("2. Para realizar un movimiento introduzca 'move' + la direccion \n");
		System.out.println("3. Si desea reiniciar la partida introduzca 'reset' \n");
		System.out.println("4. Puede salir del juego en cualquier momento introduciendo 'exit' \n ");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}

}
