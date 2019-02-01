package com.mhareza.getridofif.taskrunner.ifs;

public interface Task extends Runnable {

	void run();

	boolean isTransactional();

}
