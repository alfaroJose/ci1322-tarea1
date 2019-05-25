package ucr.ac.ecci.ci1322.tareaprogramada1.build;
import java.sql.*;
import java.util.List;

/**
 * Abstract class that manages the connections and executes statements to PostgreSQL.
 * Extends from DBConnector.
 */
public class PostgreSQLConnector extends DBConnector {
    private Connection connection;

    public PostgreSQLConnector() {}

    /**
     * Connect to a PostgreSQL database with credentials from config parameter
     * @param config
     */
    @Override
    public void createConnection(DBMSConfig config) {
        try{
            Class.forName("org.postgresql.Driver");

            //url tiene la forma: "jdbc:postgresql://host_name:port/schema"
            String url = "jdbc:postgresql://" +
                    config.getHost() + ":" +
                    config.getPort() + "/" +
                    config.getSchema();
            String user = config.getUserName();
            String pass = config.getPassword();

            connection = DriverManager.getConnection(url, user, pass);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try{
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Execute in batch the statement list
     * @param statements
     */
    @Override
    public void executeStatement(List<String> statements) {
        try{
            Statement sqlstatement = connection.createStatement();
            for(String statement : statements)
                sqlstatement.addBatch(statement);
            sqlstatement.executeBatch();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}