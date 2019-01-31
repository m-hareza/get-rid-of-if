package com.mhareza.getridofif.reportgenerator;

public interface ProgressListener {

	void started();

	void progress(int percent);

	void done();

}
