package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {

	private final Semaphore pingEvent;
	private final Semaphore pongEvent;

	public Pinger(final Semaphore pingEvent, final Semaphore pongEvent) {
		this.pingEvent = pingEvent;
		this.pongEvent = pongEvent;
	}
	
	public void run() {
		while (true) {
			try {
				pongEvent.acquire();
				println("ping");
				sleep(1);
			} catch (InterruptedException e) {
				println("Interrupted...");
			}
			pingEvent.release();
		}
	}
}