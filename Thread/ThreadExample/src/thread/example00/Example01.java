package thread.example00;

public class Example01 {

	public static void main(String[] args){
		Thread t=Thread.currentThread();
		System.out.println("Thread Details :"+t);
		t.setName("Main-Thread");
		System.out.println("Renamed Thread :"+t.getName());
		for(int i=0;i<5;i++){
			System.out.println("Main Thread Loop :"+i);
		}
	}
}
