package video.part12;

import java.util.concurrent.Semaphore;

//Advanced Java: Multi-threading Part 12 - Semaphores
public class Connection {

	private static Connection instance = new Connection();
	
	Semaphore sem = new Semaphore(10, true);
	private int connections = 0;

	public Connection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getInstance() {

		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doConnect();
		}finally {
			sem.release();
		}
	}

	public void doConnect() {
		
		
		synchronized (this) {
			connections++;
			System.out.println("Current Connections: "+connections);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
		}
		
		

	}

}
