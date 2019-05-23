package ucr.ac.ecci.ci1322.tareaprogramada1.model.JoinConfig;

import java.util.List;

public class JoinTable extends JoinConfig {
    private List<String> indexes;
    private String inverseForeignKey;
    private List<String> inverseJoinColumns;

    public JoinTable(){
        super("", "");
        this.indexes = null;
        this.inverseForeignKey = "";
        this.inverseJoinColumns = null;
    }

    public JoinTable(String name, String foreignKey, List<String> indexes,
                     String inverseForeignKey, List<String> inverseJoinColumns) {
        super(name, foreignKey);
        this.indexes = indexes;
        this.inverseForeignKey = inverseForeignKey;
        this.inverseJoinColumns = inverseJoinColumns;
    }

    @Override
    public String toString() {
        return getName() + getForeignKey();
    }

    public List<String> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<String> indexes) {
        this.indexes = indexes;
    }

    public String getInverseForeignKey() {
        return inverseForeignKey;
    }

    public void setInverseForeignKey(String inverseForeignKey) {
        this.inverseForeignKey = inverseForeignKey;
    }

    public List<String> getInverseJoinColumns() {
        return inverseJoinColumns;
    }

    public void setInverseJoinColumns(List<String> inverseJoinColumns) {
        this.inverseJoinColumns = inverseJoinColumns;
    }
}