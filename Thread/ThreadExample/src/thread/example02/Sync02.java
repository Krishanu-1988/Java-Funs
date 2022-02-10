package thread.example02;

public class Sync02 implements Runnable {

	public Thread t;
	public MyPrinter p;
	public Sync02(String name,MyPrinter p){
		this.p=p;
		t=new Thread(this,name);
		t.start();
	}

	public void run(){
		//instead of synchronized keyword before printOut() method,use of synchronized block
		synchronized (p) {
			p.printOut("Thread of Sync 02.\n");
		}		
	}
}