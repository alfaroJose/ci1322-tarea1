package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Class that stores the configuration of the library.
 */
public class Configuration {
    private String packagePath;

    public Configuration(String packagePath) {
        this.packagePath = packagePath;
    }

    public Configuration() {
        setPackage();
    }

    private void setPackage(){

    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}