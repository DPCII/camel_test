package camel_test.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import javax.jms.ConnectionFactory;

public class ActiveMQController {
    private CamelContext context;

    public ActiveMQController(CamelContext context) throws Exception {
        this.context = context;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        context.addComponent("activemq", ActiveMQComponent.jmsComponentAutoAcknowledge(connectionFactory));
    }

    public void monitorOutgoing() {
        try {
            context.addRoutes(new FileToActiveMQRoute());

            context.start();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void monitorIncoming() {
        try {
            context.addRoutes(new ActiveMQToFileRoute());

            context.start();

            ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
            String message = consumerTemplate.receiveBody("seda:receive", String.class);

            System.out.println(message);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
