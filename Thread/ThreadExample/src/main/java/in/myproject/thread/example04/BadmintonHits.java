package in.myproject.thread.example04;

public class BadmintonHits {

	public String statusFlag="initial";
	//using synchronized keyword 
	public synchronized void printOut(String msg){
		System.out.print("HIT "+msg);
		try {
			Thread.sleep(500);
			if(statusFlag.equals("initial")){
				statusFlag="2ndThread";
				wait(1);
			}
			else if(statusFlag.equals("1stThread")){
				notify();
				statusFlag="2ndThread";
				wait(1);
			}
			else if(statusFlag.equals("2ndThread")){
				notify();
				statusFlag="1stThread";
				wait(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
