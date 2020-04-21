package camel_test.activemq;

import camel_test.activemq.routes.ActiveMQToFileRoute;
import camel_test.activemq.routes.ActiveMQToPostgreSQLRoute;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

public class ActiveMQController {
    private CamelContext context;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    public ActiveMQController(CamelContext context) throws Exception {
        this.context = context;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        context.addComponent("activemq", ActiveMQComponent.jmsComponentAutoAcknowledge(connectionFactory));
    }

    public DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setPassword("");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(URL);
        return ds;
    }

    public void sendFileToActiveMQ() {
        try {
            context.addRoutes(new FileToActiveMQRoute());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFileToDirectoryFromActiveMQ() {
        try {
            context.addRoutes(new ActiveMQToFileRoute());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToPostgres() {
        try {
            context.getRegistry().bind("samplePostgreSQL", setupDataSource());
            context.addRoutes(new ActiveMQToPostgreSQLRoute());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
