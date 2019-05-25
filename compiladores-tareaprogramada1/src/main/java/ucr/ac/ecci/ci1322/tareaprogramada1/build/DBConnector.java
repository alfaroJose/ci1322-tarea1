package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import java.util.List;

/**
 * Abstract class that manages the connections and executes statements to a relational DBMS.
 */
public abstract class DBConnector {
    private Configuration configuration;

    public DBConnector() {

    }

    abstract public void createConnection(DBMSConfig config);

    abstract public void closeConnection(

    );

    abstract public void executeStatement(List<String> statements);

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}