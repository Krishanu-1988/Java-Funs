package in.myproject.thread.example03;

public class Demo {

	public static void main(String[] args){
		System.out.println("Main Thread is Starting ...");
		int counter=10;
		MyPrinter p=new MyPrinter();
		Sync01 s1=new Sync01("Thread 1",p,counter);
		Sync02 s2=new Sync02("Thread 2",p,counter);
		try {
			s1.t.join();
			s2.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread ends.");
	}
}
