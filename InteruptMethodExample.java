import java.util.Date;

/*@Author:Pradeep Mishra
 * 
 * intrupt method can be called to stop execution of running thread or sleeping thread. 
 * Interupted exception can be catched after calling interupt method as below commented line but it will clear the intrupted flag to false;
 * 
 * */

public class InteruptMethodExample {
	
	public static void main(String[] args) {
		Thread tk = new Thread(new Killer(Thread.currentThread()));
		tk.start();
		
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("i am going to sleep for some time");
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("tread was interupted");
				System.out.println("thread state now:"+Thread.currentThread().interrupted());
			}
		}
	}

}


class Killer implements Runnable {
	Thread t;

	Killer(Thread te) {
		this.t = te;
	}

	@Override
	public void run() {

		long startTime = System.currentTimeMillis();
		while (true) {
			long stopTime = System.currentTimeMillis();
			System.out.println("i want to kill ..");
			if (stopTime - startTime > 200) {
				System.out.println("i am killing now ..");
				t.interrupt();				
				break;
			}

		}
	}
}
