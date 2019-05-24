package ucr.ac.ecci.ci1322.tareaprogramada1.model;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Relation.Relation;

import java.util.List;

public class EntityData {
    private String name;
    private String strategy;
    private Relation relation;
    private List<ColumnData> columnDataList;
    private ColumnData primaryKey;

    public EntityData() {
        this.name = "";
        this.strategy = "";
        this.relation = null;
        this.columnDataList = null;
        this.primaryKey = null;
    }

    public EntityData(String name, String strategy, Relation relation, List<ColumnData> columnDataList, ColumnData primaryKey) {
        this.name = name;
        this.strategy = strategy;
        this.relation = relation;
        this.columnDataList = columnDataList;
        this.primaryKey = primaryKey;
    }

    public String toString(){
        return name + strategy + relation.toString() + columnDataList.toString() + primaryKey.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public List<ColumnData> getColumnDataList() {
        return columnDataList;
    }

    public void setColumnDataList(List<ColumnData> columnDataList) {
        this.columnDataList = columnDataList;
    }

    public ColumnData getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnData primaryKey) {
        this.primaryKey = primaryKey;
    }
}