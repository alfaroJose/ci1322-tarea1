package ucr.ac.ecci.ci1322.tareaprogramada1.model.Relation;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.JoinConfig.JoinConfig;

public class ManyToMany extends Relation {
    public ManyToMany(String mappedBy, String inverseRelation, JoinConfig joinConfig) {
        super(mappedBy, inverseRelation, joinConfig);
    }

    @Override
    public String toString() {
        return getMappedBy() + getInverseRelation() + getJoinConfig().toString();
    }
}