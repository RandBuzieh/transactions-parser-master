package com.progressoft.induction.transactionsparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;


public class CsvTransactionParser implements TransactionParser{
    @Override
    public List<Transaction> parse(File transactionsFile) {
        List<Transaction> transactions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(transactionsFile))) {
            List<String[]> csvRecords = reader.readAll();
            for (String[] csvRecord : csvRecords) {
                Transaction transaction = new Transaction();
                transaction.setDescription(csvRecord[0]);
                transaction.setDirection(csvRecord[1]);
                transaction.setAmount(BigDecimal.valueOf(Double.parseDouble(csvRecord[2])));
                transaction.setCurrency(csvRecord[3]);
                transactions.add(transaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
}
