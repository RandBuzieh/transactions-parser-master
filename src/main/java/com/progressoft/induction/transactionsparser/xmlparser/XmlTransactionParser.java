package com.progressoft.induction.transactionsparser.xmlparser;


import com.progressoft.induction.transactionsparser.transaction.Transaction;
import com.progressoft.induction.transactionsparser.parser.TransactionParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlTransactionParser implements TransactionParser {
    @Override
    public List<Transaction> parse(File transactionsFile) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(String.valueOf(transactionsFile)));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("Transaction");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Transaction transaction = new Transaction();
                    transaction.setDescription(element.getElementsByTagName("Description").item(0).getTextContent());
                    transaction.setDirection(element.getElementsByTagName("Direction").item(0).getTextContent());
                    transaction.setAmount(new BigDecimal(element.getElementsByTagName("Value").item(0).getTextContent()));
                    transaction.setCurrency(element.getElementsByTagName("Currency").item(0).getTextContent());
                    transactions.add(transaction);
                }
            }
        } catch (NumberFormatException | ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
}


