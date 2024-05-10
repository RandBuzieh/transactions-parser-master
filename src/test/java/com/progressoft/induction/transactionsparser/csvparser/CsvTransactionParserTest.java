package com.progressoft.induction.transactionsparser.csvparser;

import com.progressoft.induction.transactionsparser.context.Context;
import com.progressoft.induction.transactionsparser.helper.TestHelper;
import com.progressoft.induction.transactionsparser.transaction.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CsvTransactionParserTest {
    @Test
    public void parseCSVContent() {
        File file = new File("src/test/resources/transactions.csv");
        Context context = new Context(new CsvTransactionParser());
        List<Transaction> transactions = context.parse(file);
        assertNotNull(transactions);
        assertEquals(4, transactions.size());

        Transaction expectedTransaction1 = TestHelper.createExpectedTransaction("CLIQ payment", "Debit", BigDecimal.valueOf(1.22), "JOD");
        Transaction expectedTransaction2 = TestHelper.createExpectedTransaction("Cash withdrawal", "Debit", BigDecimal.valueOf(150), "JOD");
        Transaction expectedTransaction3 = TestHelper.createExpectedTransaction("Salary", "Credit", BigDecimal.valueOf(1000), "USD");
        Transaction expectedTransaction4 = TestHelper.createExpectedTransaction("Bill Payment", "Debit", BigDecimal.valueOf(20), "JOD");
        TestHelper.assertTransaction(expectedTransaction1, transactions.get(0));
        TestHelper.assertTransaction(expectedTransaction2, transactions.get(1));
        TestHelper.assertTransaction(expectedTransaction3, transactions.get(2));
        TestHelper.assertTransaction(expectedTransaction4, transactions.get(3));
    }

}

