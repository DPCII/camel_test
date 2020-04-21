package camel_test;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import camel_test.activemq.ActiveMQController;

public class CamelApplication {

    // Single CamelContext
    private static CamelContext context = new DefaultCamelContext();

    public static void main(String[] args) throws Exception {

        // Persists the Camel context until a graceful exit or shutdown
        Main main = new Main();
        context.start();

        ActiveMQController activeMQController = new ActiveMQController(context);
        activeMQController.writeFileToDirectoryFromActiveMQ();
        activeMQController.sendFileToActiveMQ();
        activeMQController.writeToPostgres();

        main.run(args);



    }
}
