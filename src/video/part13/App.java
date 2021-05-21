package video.part13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Advanced Java: Multi-threading Part 13 - Callable and Future
public class App {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(new Callable<Integer>() {

			public Integer call() throws Exception {

				Random random = new Random();
				int duration = random.nextInt(4000);
				System.out.println("Starting....");
				
				if(duration>2000) {
					throw new IOException("Sleeping for too long");
				}

				Thread.sleep(duration);

				System.out.println("Finished....");

				return duration;

			}
		});

		executor.shutdown();
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
