package com.progressoft.induction.transactionsparser;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        Context context;

        //CSV file parsing 
        File CSVFile = new File("C:\\Users\\DELL\\Downloads\\transactions-parser-master\\transactions-parser-master\\src\\main\\resources\\transactions.csv");
        context = new Context(new CsvTransactionParser()) ;
        System.out.println(context.parse(CSVFile));

        //CSV file parsing 
        File XMLFile = new File("C:\\Users\\DELL\\Downloads\\transactions-parser-master\\transactions-parser-master\\src\\main\\resources\\transactions.xml");
        context = new Context(new XmlTransactionParser()) ;
        System.out.println(context.parse(XMLFile));
        
        
    }
    
}
