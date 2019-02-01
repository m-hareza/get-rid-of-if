package com.mhareza.getridofif.taskrunner;

import com.mhareza.getridofif.taskrunner.ifs.RealTask;
import com.mhareza.getridofif.taskrunner.patterns.StandardTask;
import com.mhareza.getridofif.taskrunner.patterns.SynchronousExecutorService;
import com.mhareza.getridofif.taskrunner.patterns.TransactionalTask;
import java.util.concurrent.Executors;

public class TaskRunnerClient {

	public static void main(String[] args) {

		com.mhareza.getridofif.taskrunner.ifs.TaskRunner ifBasedTaskRunner = new com.mhareza.getridofif.taskrunner.ifs.TaskRunner();
		//asynchronous transactional
		ifBasedTaskRunner.setSynchronous(false);
		ifBasedTaskRunner.run(new RealTask(true));
		//asynchronous non transactional
		ifBasedTaskRunner.setSynchronous(false);
		ifBasedTaskRunner.run(new RealTask(false));
		//synchronous transactional
		ifBasedTaskRunner.setSynchronous(true);
		ifBasedTaskRunner.run(new RealTask(true));
		//synchronous non transactional
		ifBasedTaskRunner.setSynchronous(true);
		ifBasedTaskRunner.run(new RealTask(false));


		//synchronous
		com.mhareza.getridofif.taskrunner.patterns.TaskRunner synchronousPatternBasedTaskRunner  =
				new com.mhareza.getridofif.taskrunner.patterns.TaskRunner(new SynchronousExecutorService());
		//non transactional
		synchronousPatternBasedTaskRunner.runTask(new StandardTask());
		//transactional
		synchronousPatternBasedTaskRunner.runTask(new TransactionalTask(new StandardTask()));

		//asynchronous
		com.mhareza.getridofif.taskrunner.patterns.TaskRunner asynchronousPatternBasedTaskRunner  =
				new com.mhareza.getridofif.taskrunner.patterns.TaskRunner(Executors.newFixedThreadPool(10));
		//non transactional
		asynchronousPatternBasedTaskRunner.runTask(new StandardTask());
		//transactional
		asynchronousPatternBasedTaskRunner.runTask(new TransactionalTask(new StandardTask()));

	}

}
