package ucr.ac.ecci.ci1322.tareaprogramada1.model;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Relation.Relation;

import java.util.List;

public class Entity {
    private String name;
    private String strategy;
    private Relation relation;
    private List<Column> columns;
    private Column primaryKey;

    public Entity() {
        this.name = "";
        this.strategy = "";
        this.relation = null;
        this.columns = null;
        this.primaryKey = null;
    }

    public Entity(String name, String strategy, Relation relation, List<Column> columns, Column primaryKey) {
        this.name = name;
        this.strategy = strategy;
        this.relation = relation;
        this.columns = columns;
        this.primaryKey = primaryKey;
    }

    public String toString(){
        return name + strategy + relation.toString() + columns.toString() + primaryKey.toString();
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

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Column getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Column primaryKey) {
        this.primaryKey = primaryKey;
    }
}