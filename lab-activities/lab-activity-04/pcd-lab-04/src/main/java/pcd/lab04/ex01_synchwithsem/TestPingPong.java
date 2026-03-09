package pcd.lab04.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		final Semaphore pingEvent = new Semaphore(0);
		final Semaphore pongEvent = new Semaphore(1);

		new Pinger(pingEvent, pongEvent).start();
		new Ponger(pingEvent, pongEvent).start();	
	}

}
