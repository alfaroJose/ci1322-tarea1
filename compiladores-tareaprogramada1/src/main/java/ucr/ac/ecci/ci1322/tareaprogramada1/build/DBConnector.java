package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Abstract class that manages the connections and executes statements to a relational DBMS.
 */
public abstract class DBConnector {
    private Configuration configuration;

    public DBConnector(Configuration configuration) {
        this.configuration = configuration;
    }

    abstract public boolean createConnection();

    abstract public boolean closeConnection();

    abstract public boolean executeStatement(String statement);

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}