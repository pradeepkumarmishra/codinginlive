/*@Author:Pradeep Mishra
 * 
 * This example shows deadlock may occur in this type of code.
 *
 * 
 * */


public class DeadlockExample {

	public static void main(String[] args) {
		
		final SharedResource sharedResource=new SharedResource();
		final SharedResource sharedResource2=new SharedResource();
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				sharedResource.setResourceName(sharedResource2);				
			}
			
		}).start();
		
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				sharedResource2.setResourceName(sharedResource);			
			}
			
		}).start();
		
	}
	
	
	static class SharedResource{
		
		public synchronized void setResourceName(SharedResource sr){
			System.out.println(""+sr.toString());
			sr.setResourceName2(this);
		}
		public synchronized void setResourceName2(SharedResource sr){
		}
		
	}
	
	

}
