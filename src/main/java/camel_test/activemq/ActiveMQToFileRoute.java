package camel_test.activemq;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQToFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:send_queue")
//                .to("file:incoming_files");
                .to("seda:receive");
    }
}
