package ucr.ac.ecci.ci1322.tareaprogramada1.model;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Relation.Relation;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class to store the data from a Entity to insert it on a intermediate representation.
 */
public class EntityData {
    private String name;
    private String strategy;
    private Relation relation;
    private List<ColumnData> columnDataList;

    public EntityData() {
        this.name = "";
        this.strategy = "";
        this.relation = null;
        this.columnDataList = new ArrayList<>();
    }

    public EntityData(String name, String strategy, Relation relation, List<ColumnData> columnDataList) {
        this.name = name;
        this.strategy = strategy;
        this.relation = relation;
        this.columnDataList = columnDataList;
    }

    public void addColumnData( ColumnData columnData){
        columnDataList.add(columnData);
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
}