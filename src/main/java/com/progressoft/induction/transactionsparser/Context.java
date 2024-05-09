package com.progressoft.induction.transactionsparser;

import java.io.File;
import java.util.List;

public class Context {
    private TransactionParser ParseeStrategy;

    public Context(TransactionParser parseeStrategy) {
        ParseeStrategy = parseeStrategy;
    }
    public List<Transaction> parse(File transactionsFile)
    {
        return ParseeStrategy.parse(transactionsFile);
    }
}
