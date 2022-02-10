package thread.example01;

public class ThreadExample implements Runnable {

	Thread t;
	
	public ThreadExample(String name){
		t=new Thread(this,name);
		t.start();
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(t.getName()+" Loop "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(t.getName()+" ends here.");
	}
	
}
