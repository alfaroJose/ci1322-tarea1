package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import static ucr.ac.ecci.ci1322.tareaprogramada1.build.Databases.MYSQL;
import static ucr.ac.ecci.ci1322.tareaprogramada1.build.Databases.POSTGRESQL;

/**
 * Class that represents the file configuration when it's needed to save the DML script into a file.
 * Inherits from Configuration.
 */
public class FileConfig extends Configuration {
    private String fileName;
    private String filePath;
    private Databases database;

    public FileConfig(String fileName, String filePath) {
        super();
        this.fileName = fileName;
        this.filePath = filePath;
        this.database = null;
    }

    public FileConfig() {
        super();
        askFileInfo();
    }

    /**
     * Method that fills the information of the file configuration
     */
    private void askFileInfo(){
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
        System.out.println("Insert the file name to save the script: ");
        fileName = scan.nextLine();
        System.out.println("Insert the file path to save the script: ");
        filePath = scan.nextLine();
        System.out.println("[INFO]File configuration done");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Databases getDatabase() { return database; }

    public void setDatabase(Databases database) { this.database = database; }
}