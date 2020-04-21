package camel_test.activemq.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ActiveMQToFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:send_queue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Writing new file in /incoming_files which contains: " + exchange.getMessage().getBody());
                    }
                })
                .to("file:incoming_files?fileName=latest_message.txt");
//                .to("seda:receive");
    }
}
