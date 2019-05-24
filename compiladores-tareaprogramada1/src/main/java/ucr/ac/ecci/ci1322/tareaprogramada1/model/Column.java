package ucr.ac.ecci.ci1322.tareaprogramada1.model;

public class Column {
    private String name;
    private String type;
    private boolean updatable;
    private boolean nullable;
    private String length;
    private String precision;
    private String scale;
    private boolean lob;
    private String enumerated;
    private boolean isTransient ;
    private boolean id;
    private String discriminatorColumn;

    public Column() {
        this.name = "";
        this.type = "";
        this.updatable = true;
        this.nullable = true;
        this.length = "";
        this.precision = "";
        this.scale = "";
        this.lob = true;
        this.enumerated = "";
        this.isTransient = true;
        this.id = true;
        this.discriminatorColumn = "";
    }

    public Column(String name, String type, boolean updatable, boolean nullable, String length, String precision, String scale,
                  boolean lob, String enumerated, boolean isTransient, boolean id, String discriminatorColumn) {
        this.name = name;
        this.type = type;
        this.updatable = updatable;
        this.nullable = nullable;
        this.length = length;
        this.precision = precision;
        this.scale = scale;
        this.lob = lob;
        this.enumerated = enumerated;
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

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

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

    public String getEnumerated() {
        return enumerated;
    }

    public void setEnumerated(String enumerated) {
        this.enumerated = enumerated;
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