package video.part14;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//Advanced Java: Multi-threading Part 14 - Interrupting Threads
public class App2 {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newCachedThreadPool();

		System.out.println("Starting");

		Future<?> fu = executor.submit(new Callable<Void>() {

			public Void call() throws Exception {

				Random random = new Random();

				for (int i = 0; i < 1E8; i++) {

					if (Thread.currentThread().isInterrupted()) {
						System.out.println("OOps I am Interrupted!");
						break;
					}

					Math.sin(random.nextDouble());
				}
				return null;
			}
		});
		
		executor.shutdown();
		
		Thread.sleep(500);
		
		fu.cancel(true);
		
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Ending");


	}

}
