package camel_test.hello_world;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;


public class HelloWorld {

    public static void run() {

        try {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new HelloWorldRoute());

        context.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
