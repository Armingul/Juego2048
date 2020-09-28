package tp.pr1;

public class MoveResults {

private int score;
private int highest;



	public MoveResults() {
		this.score=0;
		this.highest=0;
	}

	public void setScore(int sum){
		
		this.score += sum;
	}
	
	public void setHighest(int max){
		this.highest=max;
		
	}
	public int getScore(){
		return this.score;
		
	}
	public int getHighest(){
		return this.highest;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
