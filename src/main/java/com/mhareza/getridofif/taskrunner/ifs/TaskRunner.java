package com.mhareza.getridofif.taskrunner.ifs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {

	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	private boolean synchronous;

	public void run(Task task) {
		if (synchronous) {
			if (task.isTransactional()) {
				runInTransaction(task);
			} else {
				task.run();
			}
		} else {
			if (task.isTransactional()) {
				executorService.submit(() -> runInTransaction(task));
			} else {
				executorService.submit(task);
			}
		}
	}

	private void runInTransaction(Task task) {
		//start transaction
		task.run();
		//commit transaction
	}

	public void setSynchronous(boolean synchronous) {
		this.synchronous = synchronous;
	}
}

