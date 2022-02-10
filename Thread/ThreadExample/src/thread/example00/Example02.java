package thread.example00;

class Example02 implements Runnable {
	
	Thread ct;
	public Example02() {
		ct=new Thread(this,"Child-Thread");
		ct.start();
	}
	
	@Override
	public void run() { //Child Thread tasks
		for(int i=0;i<5;i++){
			System.out.println("Child Thread Loop :"+i);
		}	
		System.out.println("Child Thread ends here.");
	}

	public static void main(String[] args){
		//Main Thread tasks
		Thread t=Thread.currentThread();
		System.out.println("Thread Details :"+t);
		t.setName("Main-Thread");
		System.out.println("Renamed Thread :"+t.getName());
		
		//Creating Child Thread
		Example02 exct=new Example02();

		for(int i=0;i<5;i++){
			System.out.println("Main Thread Loop :"+i);
		}
		//Sleep 1000 ms to make the main thread execution as last
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//Using join instead of sleep() method
		try {
			exct.ct.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread status :"+t.isAlive());
		System.out.println("Main Thread ends here.");
	}
}
