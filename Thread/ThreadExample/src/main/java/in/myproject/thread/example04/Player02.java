package in.myproject.thread.example04;

public class Player02 implements Runnable {

	public Thread t;
	public BadmintonHits p;
	public int count;
	public Player02(String name,BadmintonHits p,int count){
		this.p=p;
		this.count=count;
		t=new Thread(this,name);
		t.start();
	}

	public void run(){
		for(int i=0;i<count;i++){
			p.printOut("Player 02 : Round "+i+"\n");
		}		
	}
}