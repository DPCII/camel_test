package camel_test.database;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQToPostgreSQLRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:db_queue")
                .process(new InsertProcessor())
                .to("jdbc:samplePostgreSQL");
    }
}
