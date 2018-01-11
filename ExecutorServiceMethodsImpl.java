/*@Author:Pradeep Mishra
 * 
 * This example shows implementation for executorservice interface methods implementation
 * 
 * */

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMethodsImpl {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);

		es.execute(() -> {
			System.out.println("executed by executor service.." + Thread.currentThread().getName());
		});

		Future<String> future = es.submit(() -> {
			System.out.println("executed by executor service via submit.." + Thread.currentThread().getName());
			return "pradeep";

		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
		}

		Set<Callable<String>> collection = new HashSet<>();
		collection.add(() -> {
			return "Mishra";
		});
		collection.add(() -> {
			return "Soni";
		});

		try {
			String result = es.invokeAny(collection);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
		}

		System.out.println("executed by main thread..." + Thread.currentThread().getName());
	}

}
