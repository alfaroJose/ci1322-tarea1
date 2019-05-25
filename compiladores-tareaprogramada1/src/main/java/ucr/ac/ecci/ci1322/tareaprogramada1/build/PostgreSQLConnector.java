package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import java.util.List;

/**
 * Abstract class that manages the connections and executes statements to a PostgreSQL DBMS.
 *  * Extends from DBConnector.
 */
public class PostgreSQLConnector extends DBConnector {
    public PostgreSQLConnector (){}

    @Override
    public void createConnection(DBMSConfig config) {

    }

    @Override
    public void closeConnection() {}

    @Override
    public void executeStatement(List<String> statements) {

    }
}