/*@Author:Pradeep Mishra
 * 
 * This example shows deadlock may occur in this type of code.
 *
 * 
 * */


public class DeadlockExample {

	public static void main(String[] args) {
		
		DeadlockExample.SharedResource sharedResource=new DeadlockExample().new SharedResource();
		
		Thread t=new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("setting reource name from child thread");
				
			//Child thread acquires lock on sharedResource object and wait for release on lock  held by main thread
				sharedResource.setResourceName("Mishra");				
			}
			
		});
		t.start();
		
		//Main thread acquires lock on sharedResource object and wait for release lock held by child thread
			sharedResource.setResourceName2("P");
		
	}
	
	
	class SharedResource{
		private String resourceName;
		
		public synchronized void setResourceName(String resourceName){
			this.resourceName=resourceName;
			setResourceName2("rersource2");
		}
		public synchronized void setResourceName2(String resourceName){
			this.resourceName=resourceName;
			setResourceName("rersource1");
		}
		
	}
	
	

}
