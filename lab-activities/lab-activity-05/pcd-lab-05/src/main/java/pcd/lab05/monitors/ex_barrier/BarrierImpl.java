package pcd.lab05.monitors.ex_barrier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Barrier
 */
public class BarrierImpl implements Barrier {
	
	private final int nParticipants;
	private int nArrived = 0;
	private final Lock mutex;
	private final Condition allArrived;

	public BarrierImpl(final int nParticipants) {
		this.nParticipants = nParticipants;
		this.mutex = new ReentrantLock();
		this.allArrived = mutex.newCondition();
	}
	
	@Override
	public void hitAndWaitAll() throws InterruptedException {
		try {
			mutex.lock();
			nArrived++;
			if(nArrived < nParticipants) {
				allArrived.await();
			} else {
				allArrived.signalAll();
			}
		} finally {
			mutex.unlock();
		}
	}

	
}
