package com.progressoft.induction.transactionsparser.csvparser;

import com.progressoft.induction.transactionsparser.transaction.Transaction;
import com.progressoft.induction.transactionsparser.parser.TransactionParser;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CsvTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(File transactionsFile) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        StreamFactory factory = StreamFactory.newInstance();

        factory.load("src/main/resources/beanio/CsvMapping.xml");

        BeanReader in = factory.createReader("transactionFile", transactionsFile);
        Transaction transaction;
        while ((transaction = (Transaction) in.read()) != null) {
            transactions.add(transaction);
        }
        in.close();
        return transactions;
    }
}
