package camel_test.activemq.routes;

import camel_test.database.GetBodyProcessor;
import org.apache.camel.builder.RouteBuilder;

public class ActiveMQToPostgreSQLRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:db_queue")
                .process(new GetBodyProcessor())
                .to("jdbc:samplePostgreSQL");


    }
}
