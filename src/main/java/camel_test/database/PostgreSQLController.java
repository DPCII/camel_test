package camel_test.database;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;


public class PostgreSQLController {
    private CamelContext context;
    private String url = "jdbc:postgresql://localhost:5432/postgres";

    public PostgreSQLController(CamelContext context) {
        this.context = context;
    }

    public DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setPassword("");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(url);
        return ds;
    }

    public void manageDB() {
        try {

        context.getRegistry().bind("samplePostgreSQL", setupDataSource());

        context.addRoutes(new ActiveMQToPostgreSQLRoute());

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
