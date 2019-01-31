package com.mhareza.getridofif.reportgenerator.nullparameters;

import com.mhareza.getridofif.reportgenerator.ProgressListener;
import com.mhareza.getridofif.reportgenerator.Transaction;
import com.mhareza.getridofif.reportgenerator.TransactionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportGenerator {

	private final TransactionRepository transactionRepository;

	public ReportGenerator(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<String> generate(Date startDate, Date endDate, ProgressListener listener) {
		if (endDate == null) {
			endDate = new Date();
		}

		if (listener != null) {
			listener.started();
		}

		final List<String> reports = new ArrayList<>();
		final List<Transaction> allTransactions = transactionRepository.getAllTransactions();
		final int allTransactionsNumber = allTransactions.size();
		for (int i = 0; i < allTransactionsNumber; ++i) {
			final Transaction transaction = allTransactions.get(i);
			if (happenedBetween(transaction, startDate, endDate)) {
				reports.add(transaction.getReport());
			}
			int percent = Math.round((i * 100.0f) / allTransactionsNumber);
			if (listener != null) {
				listener.progress(percent);
			}
		}

		if (listener != null) {
			listener.done();
		}
		return reports;
	}

	private boolean happenedBetween(Transaction transaction, Date startDate, Date endDate) {
		return !transaction.getDate().before(startDate) && !transaction.getDate().after(endDate);
	}

}
