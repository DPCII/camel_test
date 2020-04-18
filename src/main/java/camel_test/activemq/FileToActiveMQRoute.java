package camel_test.activemq;

import org.apache.camel.builder.RouteBuilder;

public class FileToActiveMQRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:outgoing_files?noop=true")
                .to("activemq:queue:receive_queue");
    }
}
