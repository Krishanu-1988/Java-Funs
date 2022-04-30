package in.myproject.thread.example01;

public class Demo {

	public static void main(String[] args){
		ThreadExample ob1=new ThreadExample("Child-1");
		ThreadExample ob2=new ThreadExample("Child-2");
		for(int i=0;i<5;i++){
			System.out.println("Main Loop "+i);
		}
		try {
			ob1.t.join();
			ob2.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread ends here.");
	}
}
