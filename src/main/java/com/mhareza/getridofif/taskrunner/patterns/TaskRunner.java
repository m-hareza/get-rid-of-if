package com.mhareza.getridofif.taskrunner.patterns;

import java.util.concurrent.ExecutorService;

public class TaskRunner {

	private final ExecutorService executorService;

	public TaskRunner(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public void runTask(Task task) {
		executorService.submit(task);
	}

}
