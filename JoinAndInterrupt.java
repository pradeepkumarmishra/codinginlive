
public class JoinAndInterrupt {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			boolean taskCompleted=false;
			long startTime = System.currentTimeMillis();
			while (!taskCompleted) {
				long stopTime = System.currentTimeMillis();
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				System.out.println("i am child of main..let me complete first");
				if(stopTime-startTime>6000){
					taskCompleted=true;
					Thread.currentThread().interrupt();	
					System.out.println("I am completed ..thank you!");
				}
			}
		});

		t1.start();

		while (!Thread.currentThread().isInterrupted()) {
			try {
				t1.join();
			} catch (Exception e) {
			}
			
			System.out.println("i am main thread but i can wait for my child..");
		}

	}

}
