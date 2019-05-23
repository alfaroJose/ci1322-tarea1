package ucr.ac.ecci.ci1322.tareaprogramada1.model.JoinConfig;

public abstract class JoinConfig {
    private String name;
    private String foreignKey;

    public JoinConfig() {
        this.name = "";
        this.foreignKey = "";
    }

    public JoinConfig(String name, String foreignKey) {
        this.name = name;
        this.foreignKey = foreignKey;
    }

    abstract public String toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }
}