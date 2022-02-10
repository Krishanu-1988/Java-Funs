package thread.example02;

public class MyPrinter {

	//using synchronized keyword 
	//public synchronized void printOut(String msg){
	//without using synchronized keyword
	public void printOut(String msg){
		for(int i=5;i>0;i--){
		System.out.print("Message : "+msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
