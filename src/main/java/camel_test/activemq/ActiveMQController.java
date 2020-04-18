package camel_test.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class ActiveMQController {

    public static void monitorOutgoing() {
        try {
            CamelContext context = new DefaultCamelContext();

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

            context.addRoutes(new FileToActiveMQRoute());

            context.start();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorIncoming() {
        try {
            CamelContext context = new DefaultCamelContext();

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

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
