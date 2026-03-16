package pcd.lab05.monitors.ex_latch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Latch
 */
public class LatchImpl implements Latch {
	
	private int workersCount;
	private final Lock mutex;
	private final Condition workersPassed;

	public LatchImpl(final int nWorkers) {
		this.workersCount = nWorkers;
		this.mutex = new ReentrantLock();
		this.workersPassed = mutex.newCondition();
	}
	
	@Override
	public void await() throws InterruptedException {
		try {
			mutex.lock();
			if (workersCount > 0) {
				workersPassed.await();
			}
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public void countDown() {
		try {
			mutex.lock();
			workersCount--;
			if(workersCount == 0) {
				workersPassed.signal();
			}
		} finally {
			mutex.unlock();
		}
	}

}
