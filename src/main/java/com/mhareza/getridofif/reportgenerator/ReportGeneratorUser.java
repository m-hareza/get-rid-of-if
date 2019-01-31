package com.mhareza.getridofif.reportgenerator;

import java.util.Date;

public class ReportGeneratorUser {

	public static void main(String[] args) {
		TransactionRepository transactionRepository = new TransactionRepositoryImpl();
		final Date startDate = new Date();
		final Date endDate = new Date();
		final SaveToFileProgressListener listener = new SaveToFileProgressListener();

		//optional parameters
		com.mhareza.getridofif.reportgenerator.nullparameters.ReportGenerator reportGeneratorWithNullableParameters =
				new com.mhareza.getridofif.reportgenerator.nullparameters.ReportGenerator(transactionRepository);

		reportGeneratorWithNullableParameters.generate(startDate, endDate, listener);
		reportGeneratorWithNullableParameters.generate(startDate, endDate, null);
		reportGeneratorWithNullableParameters.generate(startDate, null, listener);
		reportGeneratorWithNullableParameters.generate(startDate, null, null);

		//null object
		com.mhareza.getridofif.reportgenerator.nullobject.ReportGenerator reportGeneratorWithNullObject =
				new com.mhareza.getridofif.reportgenerator.nullobject.ReportGenerator(transactionRepository);

		reportGeneratorWithNullObject.generate(startDate, endDate, listener);
		reportGeneratorWithNullObject.generate(startDate, endDate);
		reportGeneratorWithNullObject.generate(startDate, listener);
		reportGeneratorWithNullObject.generate(startDate);

	}

}
