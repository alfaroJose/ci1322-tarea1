package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import static ucr.ac.ecci.ci1322.tareaprogramada1.build.Databases.MYSQL;
import static ucr.ac.ecci.ci1322.tareaprogramada1.build.Databases.POSTGRESQL;

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

    public DBMSConfig() {
        super("");
        this.userName = "";
        this.password = "";
        this.host = "";
        this.schema = "";
        this.database = null;
        askConfig();
    }

    private void askConfig(){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String answer;
        boolean flag = true;
        while(flag){
            System.out.println("Pick the number with de DBMS target code: 1-MySQL 2-PostGreSQL ");
            answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("1")) {
                database = MYSQL;
                flag = false;
            }
            else if (answer.equals("2")) {
                database = POSTGRESQL;
                flag = false;
            }
            else
                System.out.println("Please answer 1 or 2");
        }
        System.out.println("Insert the username in the DBMS");
        userName = scan.nextLine();
        System.out.println("Insert the password of the user " + userName + " in the DBMS");
        password = scan.nextLine();
        System.out.println("Insert the host yopu want to use in the DBMS");
        host = scan.nextLine();
        System.out.println("Insert the scheme in which you want to work in the DBMS");
        schema = scan.nextLine();
        System.out.println("[INFO]DBMS configuration done");
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