package camel_test.database;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetBodyProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        System.out.println("Message to insert: " + body);
        String insertQuery = "INSERT INTO test_db_camel (\"message\") VALUES('" + body + "')";
        exchange.getIn().setBody(insertQuery);
    }
}
