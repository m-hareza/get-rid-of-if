package com.mhareza.getridofif.taskrunner.patterns;

public class TransactionalTask implements Task {

	private Task task;

	public TransactionalTask(Task task) {
		this.task = task;
	}

	@Override
	public void run() {
		//start transaction
		task.run();
		//close transaction
	}
}
