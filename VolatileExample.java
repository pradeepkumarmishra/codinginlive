/*@Author:Pradeep Mishra
 * 
 * this exmple try to explaining memory consistency issue resolution using Volatile
 * Volatile variables makes variable to read from main memory and variable value is not cached.
 * 
 * marking shared variable volatile helps only when there is only one write thread is available and others are read only
 * */

public class VolatileExample {

	public static void main(String[] args) {
		IntCounter count = new IntCounter();
		ChildThread runnableT=new ChildThread(Thread.currentThread(),count);
		
		Thread t = new Thread(runnableT);
		t.start();

		while (!Thread.currentThread().isInterrupted()) {
			count.incremant();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Thread was intrrupted..");
				break;
			}
			System.out.println("count from main " + count.getCount());
		}

	}

}


class ChildThread implements Runnable{
	Thread t;
	IntCounter count;
	ChildThread(Thread t,IntCounter c){
		this.t=t;
		this.count=c;
	}
	
		@Override
		public void run() {
			while (true) {
				if (count.getCount() > 10) {
					System.out.println("interrupting main thread "+t.getName());
					t.interrupt();
					break;
					
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				
				//count.incremant();//enabling this line breaks volatile resolution
				
				
				System.out.println("count from child " + count.getCount());
			}
		}
    }

class IntCounter {

	volatile private int  count = 0;

	public void incremant() {
		this.count++;
	}

	public void decremant() {
		this.count--;
	}

	int getCount() {
		return this.count;
	}
}

