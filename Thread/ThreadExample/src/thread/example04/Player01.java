package thread.example04;

public class Player01 implements Runnable {

	public Thread t;
	public BadmintonHits p;
	public int count;
	public Player01(String name,BadmintonHits p,int count){
		this.p=p;
		this.count=count;
		t=new Thread(this,name);
		t.start();
	}
	
	public void run(){
		for(int i=0;i<count;i++){
			p.printOut("Player 01 : Round "+i+"\n");
		}		
	}
}
