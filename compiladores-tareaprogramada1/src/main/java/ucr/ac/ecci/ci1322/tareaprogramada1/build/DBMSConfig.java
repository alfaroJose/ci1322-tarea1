package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Class that represents the DBMS configuration when it's needed to run the DML script into a DBMS.
 * Inherits from Configuration.
 */
public class DBMSConfig extends Configuration {
    private String userName;
    private String password;
    private String host;
    private String schema;
    private Databases database;

    public DBMSConfig(String userName, String password, String host,
                      String schema, Databases database) {
        super();
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.schema = schema;
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Databases getDatabase() {
        return database;
    }

    public void setDatabase(Databases database) {
        this.database = database;
    }
}