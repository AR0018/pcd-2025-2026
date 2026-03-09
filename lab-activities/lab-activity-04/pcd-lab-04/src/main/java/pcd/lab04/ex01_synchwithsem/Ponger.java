package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {

	private final Semaphore pingEvent;
	private final Semaphore pongEvent;
	
	public Ponger(final Semaphore pingEvent, final Semaphore pongEvent) {
		this.pingEvent = pingEvent;
		this.pongEvent = pongEvent;
	}
	
	public void run() {
		while (true) {
			try {
				pingEvent.acquire();
				println("pong");
				sleep(1);
			} catch (InterruptedException e) {
				println("Interrupted...");
			}
			pongEvent.release();
		}
	}
}