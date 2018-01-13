/*@Author:Pradeep Mishra
 * 
 * Cyclic barrier example
 * 
 * */

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier cr=new CyclicBarrier(3,()->{
			System.out.println("barrier thread");
			try {
				System.out.println("all parties reached...");;//wait till other thread are done till this line
			} catch (Exception e) {
			}
			//System.out.println("first thread barrier passed");
		});
		
		new Thread(()->{
			System.out.println("first thread");
			try {
				cr.await();//wait till other thread are done till this line
			} catch (Exception e) {
			}
			System.out.println("first thread barrier passed");
		}).start();
		
		new Thread(()->{
			System.out.println("2nd thread");
			try {
				System.out.println("2nd thread line2");
				cr.await();//wait till other thread are done till this line
			} catch (Exception e) {
			}
			System.out.println("2nd thread barrier passed");
		}).start();
		
		new Thread(()->{
			System.out.println("third thread");
			try {
				cr.await();//wait till other thread are done till this line
			} catch (Exception e) {
			}
			System.out.println("third thread barrier passed");
		}).start();
	}

}
