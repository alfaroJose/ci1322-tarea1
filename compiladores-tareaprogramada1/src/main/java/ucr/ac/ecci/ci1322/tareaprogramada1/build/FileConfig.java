package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Class that represents the file configuration when it's needed to save the DML script into a file.
 * Inherits from Configuration.
 */
public class FileConfig extends Configuration {
    private String fileName;
    private String filePath;

    public FileConfig(String fileName, String filePath) {
        super();
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public FileConfig() {
        super();
        setFileInfo();
    }

    private void setFileInfo(){

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
}