package video.part2;

import java.util.Scanner;

//Use of volatile Keyword.
class Processor extends Thread {

	// To ensure that updates to variables propagate predictably to other threads,
	// we should apply the volatile modifier to those variables:
	private volatile boolean running = true;

	// Method of Thread class.
	@Override
	public void run() {

		while (running) {

			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {

		running = false;
	}

}

public class App {

	public static void main(String[] args) {

		Processor process1 = new Processor();

		// Start method will tell Thread class to execute thread using run method in
		// processor class.
		process1.start();

		System.out.println("Press return to stop.....");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		process1.shutdown();
	}

}
