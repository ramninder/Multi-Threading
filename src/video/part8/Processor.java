package video.part8;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {

		synchronized (this) {

			System.out.println("Produce thread running......");
			wait();
			System.out.println("Resume");
		}

	}

	public void consume() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Thread.sleep(3000);

		synchronized (this) {
			System.out.println("Waiting for the return key");
			scan.nextLine();
			System.out.println("return key pressed");
			notify();
			Thread.sleep(5000);
			
		}
	}

}
