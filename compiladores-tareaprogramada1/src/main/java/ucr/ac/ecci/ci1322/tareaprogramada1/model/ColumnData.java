package ucr.ac.ecci.ci1322.tareaprogramada1.model;

/**
 *  Class to store the data from a Column to insert it on a EntityData list of columns.
 */
public class ColumnData {
    private String name;
    private String type;
    private boolean nullable;
    private String length;
    private String precision;
    private String scale;
    private boolean lob;
    private boolean isTransient ;
    private boolean id;
    private String discriminatorColumn;

    public ColumnData() {
        this.name = "";
        this.type = "";
        this.nullable = false;
        this.length = "";
        this.precision = "";
        this.scale = "";
        this.lob = false;
        this.isTransient = false;
        this.id = false;
        this.discriminatorColumn = "";
    }

    public ColumnData(String name, String type, boolean nullable, String length, String precision, String scale,
                      boolean lob, boolean isTransient, boolean id, String discriminatorColumn) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
        this.length = length;
        this.precision = precision;
        this.scale = scale;
        this.lob = lob;
        this.isTransient = isTransient;
        this.id = id;
        this.discriminatorColumn = discriminatorColumn;
    }

    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public boolean isLob() {
        return lob;
    }

    public void setLob(boolean lob) {
        this.lob = lob;
    }

    public boolean isTransient() {
        return isTransient;
    }

    public void setTransient(boolean aTransient) {
        isTransient = aTransient;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public String getDiscriminatorColumn() {
        return discriminatorColumn;
    }

    public void setDiscriminatorColumn(String discriminatorColumn) {
        this.discriminatorColumn = discriminatorColumn;
    }
}