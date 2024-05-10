package com.progressoft.induction.transactionsparser.context;

import com.progressoft.induction.transactionsparser.transaction.Transaction;
import com.progressoft.induction.transactionsparser.parser.TransactionParser;

import java.io.File;
import java.util.List;

public class Context {
    private TransactionParser parseStrategy;

    public Context(TransactionParser parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public List<Transaction> parse(File transactionsFile) {
        return parseStrategy.parse(transactionsFile);
    }
}
