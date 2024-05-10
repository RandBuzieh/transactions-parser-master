package com.progressoft.induction.transactionsparser.main;

import com.progressoft.induction.transactionsparser.xmlparser.XmlTransactionParser;
import com.progressoft.induction.transactionsparser.context.Context;
import com.progressoft.induction.transactionsparser.csvparser.CsvTransactionParser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Context context;

        //CSV file parsing 
        File csvFile = new File("src/main/resources/transactions.csv");
        context = new Context(new CsvTransactionParser());
        System.out.println("From CSV File :" + context.parse(csvFile));

        //XML file parsing 
        File xmlFile = new File("src/main/resources/transactions.xml");
        context = new Context(new XmlTransactionParser());
        System.out.println("From XML File :" + context.parse(xmlFile));


    }

}
