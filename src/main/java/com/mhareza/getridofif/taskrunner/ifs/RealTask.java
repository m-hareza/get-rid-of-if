package com.mhareza.getridofif.taskrunner.ifs;

public class RealTask implements Task {

	private final boolean transactional;

	public RealTask(boolean transactional) {
		this.transactional = transactional;
	}

	@Override
	public void run() {
		System.out.println("It is fun");
	}

	@Override
	public boolean isTransactional() {
		return transactional;
	}
}
