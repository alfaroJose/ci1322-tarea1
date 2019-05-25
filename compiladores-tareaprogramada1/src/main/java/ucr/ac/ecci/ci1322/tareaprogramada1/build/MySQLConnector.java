package ucr.ac.ecci.ci1322.tareaprogramada1.build;
import java.sql.*;
import java.util.List;

/**
 * Abstract class that manages the connections and executes statements to MySQL DBMS.
 * Extends from DBConnector.
 */
public class MySQLConnector extends DBConnector {
    private Connection connection;

    public MySQLConnector() {}

    /**
     * Connect to a MYSQL database with credentials from config parameter
     * @param config
     */
    @Override
    public void createConnection(DBMSConfig config) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            //url tiene la forma: "jdbc:mysql://host_name:port/schema"
            String url = "jdbc:mysql://" +
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