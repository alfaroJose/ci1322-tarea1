package ucr.ac.ecci.ci1322.tareaprogramada1.model.JoinConfig;

public class JoinColumn extends JoinConfig {
    private boolean insertable;
    private boolean nullable;
    private String referencedColumnName;
    private String table;
    private boolean unique;
    private boolean updatable;

    public JoinColumn() {
        super("", "");
        this.insertable = true;
        this.nullable = true;
        this.referencedColumnName = "";
        this.table = "";
        this.unique = true;
        this.updatable = true;
    }

    public JoinColumn(String name, String foreignKey, boolean insertable, boolean nullable,
                      String referencedColumnName, String table, boolean unique, boolean updatable) {
        super(name, foreignKey);
        this.insertable = insertable;
        this.nullable = nullable;
        this.referencedColumnName = referencedColumnName;
        this.table = table;
        this.unique = unique;
        this.updatable = updatable;
    }

    @Override
    public String toString() {
        return null;
    }

    public boolean isInsertable() {
        return insertable;
    }

    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }
}