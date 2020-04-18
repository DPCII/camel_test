package camel_test;

import org.apache.camel.main.Main;
import camel_test.activemq.ActiveMQController;


public class CamelApplication {



    public static void main(String[] args) throws Exception {

        Main main = new Main();

        ActiveMQController.monitorOutgoing();
        ActiveMQController.monitorIncoming();

        // Persists
        main.run(args);



    }
}
