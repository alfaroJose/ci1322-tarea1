package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import java.util.List;

/**
 * Abstract class that manages the connections and executes statements to a relational DBMS.
 */
public abstract class DBConnector {

    public DBConnector() {

    }

    /**
     * Method that creates a connection to a SQL DBMS
     * @param config the DBMS config
     */
    abstract public void createConnection(DBMSConfig config);

    /**
     * Method that closes the connection to a SQL DBMS
     */
    abstract public boolean closeConnection();

    /**
     * Method that executes statements in a SQL DBMS
     * @param statements the statements to be executed
     */
    abstract public void executeStatement(List<String> statements);

}