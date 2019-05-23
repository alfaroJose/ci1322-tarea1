package ucr.ac.ecci.ci1322.tareaprogramada1.model.Relation;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.JoinConfig.JoinConfig;

public abstract class Relation {
    private String mappedBy;
    private String inverseRelation;
    private JoinConfig joinConfig;

    public Relation() {
        this.mappedBy = "";
        inverseRelation = "";
        joinConfig = null;
    }

    public Relation(String mappedBy, String inverseRelation, JoinConfig joinConfig) {
        this.mappedBy = mappedBy;
        this.inverseRelation = inverseRelation;
        this.joinConfig = joinConfig;
    }

    abstract public String toString();

    public String getMappedBy() {
        return mappedBy;
    }

    public void setMappedBy(String mappedBy) {
        this.mappedBy = mappedBy;
    }

    public String getInverseRelation() {
        return inverseRelation;
    }

    public void setInverseRelation(String inverseRelation) {
        this.inverseRelation = inverseRelation;
    }

    public JoinConfig getJoinConfig() {
        return joinConfig;
    }

    public void setJoinConfig(JoinConfig joinConfig) {
        this.joinConfig = joinConfig;
    }
}