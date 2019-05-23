package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class that controls the library
 */
public class Controller {
    private Configuration configuration;
    private DBConnector connector;
    private CodeGenerator codeGenerator;
    private Scanner scanner;
    private IRBuilder builder;

    public Controller() {
        this.configuration = null;
        this.connector = null;
        this.codeGenerator = null;
        this.scanner = new Scanner();
        this.builder = new IRBuilder();
    }

    public Controller(Configuration configuration, DBConnector connector, CodeGenerator codeGenerator,
                      Scanner scanner, IRBuilder builder) {
        this.configuration = configuration;
        this.connector = connector;
        this.codeGenerator = codeGenerator;
        this.scanner = scanner;
        this.builder = builder;
    }

    /**
     *  Method that runs the library and creates a DML script or runs it into de DBMS
     */
    public void run(){
        boolean generateScript = confirmationMessage("Generate the DML script in a file y/n: ");
        boolean runScript = confirmationMessage("Run the DML script in a DBMS y/n: ");
        if(generateScript){
            FileConfig fileConfig = new FileConfig();
            List<String> packagesList = new ArrayList<>();
            Package[] packages = Package.getPackages();
            String scannedPackage;
            for(Package pack : packages){
                packagesList.add(pack.getName());
                scannedPackage = pack.getName();
                scanner.scan(scannedPackage);
            }
            scanner.printClasses();
            scanner.printTables();
            scanner.printColumns();

            builder.parse(scanner.getClassList());

            if(runScript){
                System.out.println("hihi");
            }
        }

    }

    /**
     * Method that ask the user to press "y" or "n" to confirm a message
     * @param message the message to be shown
     * @return true if the "y" is the input or false if the "n" is.
     */
    private boolean confirmationMessage(String message){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String answer;
        boolean flag = true;
        boolean confirmation = false;
        while (flag) {
            System.out.println(message);
            answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                confirmation = true;
                flag = false;
            }
            else if (answer.equals("n"))
                flag = false;
            else
                System.out.println("Please answer y or n");
        }
        return confirmation;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public DBConnector getConnector() {
        return connector;
    }

    public void setConnector(DBConnector connector) {
        this.connector = connector;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public IRBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(IRBuilder builder) {
        this.builder = builder;
    }
}
