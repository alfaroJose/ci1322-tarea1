package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Abstract class that manages the connections and executes statements to a PostgreSQL DBMS.
 *  * Extends from DBConnector.
 */
public class PostgreSQLConnector extends DBConnector {
    public PostgreSQLConnector(Configuration configuration) {
        super(configuration);
    }

    @Override
    public boolean createConnection() {
        return false;
    }

    @Override
    public boolean closeConnection() {
        return false;
    }

    @Override
    public boolean executeStatement(String statement) {
        return false;
    }
}