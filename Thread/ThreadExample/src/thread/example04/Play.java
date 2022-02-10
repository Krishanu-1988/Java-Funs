package thread.example04;

public class Play {

	public static void main(String[] args){
		System.out.println("MATCH IS STARTING WITHIN 3 SECONDS ...");
		try {
			System.out.println();
			Thread.sleep(1000);
			System.out.println("ONE");
			Thread.sleep(1000);
			System.out.println("TWO");
			Thread.sleep(1000);
			System.out.println("START");
			Thread.sleep(200);
			System.out.println();
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int hitCounts=(int)(Math.random()*10); //Randomly chooses no of rounds 
		int servicePerson=pickOneOrTwo();
		int winner=pickOneOrTwo();
		Player01 p1;
		Player02 p2;
		BadmintonHits p=new BadmintonHits(); 
		if(winner==1){
			if(servicePerson==1){
				p1=new Player01("Thread 1",p,hitCounts);
				p2=new Player02("Thread 2",p,hitCounts-1);
			}
			else{
				p2=new Player02("Thread 2",p,hitCounts);
				p1=new Player01("Thread 1",p,hitCounts);
			}
		}
		else{
			if(servicePerson==1){
				p1=new Player01("Thread 1",p,hitCounts);
				p2=new Player02("Thread 2",p,hitCounts);
			}
			else{
				p2=new Player02("Thread 2",p,hitCounts);
				p1=new Player01("Thread 1",p,hitCounts-1);
			}
		}
		try {
			p1.t.join();
			p2.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(winner==1 && servicePerson==1){
		System.out.println("DROP Player 02 : Round "+(hitCounts-1)); //Final Drop by the player 02
		}
		else if(winner==1 && servicePerson==2){
		System.out.println("DROP Player 02 : Round "+hitCounts); //Final Drop by the player 02
		}
		else if(winner==2 && servicePerson==2){
			System.out.println("DROP Player 01 : Round "+(hitCounts-1)); //Final Drop by the player 01
		}
		else{
		System.out.println("DROP Player 01 : Round "+hitCounts); //Final Drop by the player 01
		}
		System.out.println();
		System.out.println("WINNER : Player 0"+winner);
		System.out.println("CONGRATULATION Player 0"+winner+" !!");
	}
	
	public static int pickOneOrTwo(){ //This will select randomly between 1 or 2
		while(true){
			int ran=(int)(Math.random()*10);
			if(ran==1||ran==2)
			return ran;
		}
	}
}
