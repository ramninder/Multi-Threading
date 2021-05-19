package video.part3;

//Advanced Java: Multi-threading Part 3 -- The Synchronized Keyword
public class App {

	private int count = 0;

	public static void main(String[] args) {

		App app = new App();
		app.doWork();
	}

	// Output should be 20000 but without syncronized key word it was different
	// because each thread was missing some processes.Syncronized add intrinsic lock
	// on method until one thread finishes methos is not given to any other thread for use.
	public synchronized void increment() {
		count++;
	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					// count++;
					increment();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++) {
					// count++;
					increment();
				}

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Count: " + count);
	}

}
