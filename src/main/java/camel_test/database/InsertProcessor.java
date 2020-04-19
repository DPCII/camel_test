package camel_test.database;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String input = (String) exchange.getIn().getBody();
        System.out.println("String to insert: " + input);
        String insertQuery = "INSERT INTO test_db_camel VALUES (" + input + ")";
        exchange.getIn().setBody(insertQuery);
    }
}
