package in.myproject.thread.example03;

public class Sync02 implements Runnable {

	public Thread t;
	public MyPrinter p;
	public int count;
	public Sync02(String name,MyPrinter p,int count){
		this.p=p;
		this.count=count;
		t=new Thread(this,name);
		t.start();
	}

	public void run(){
		for(int i=count;i>0;i--){
			p.printOut("Thread of Sync 02. "+i+"\n");
		}		
	}
}