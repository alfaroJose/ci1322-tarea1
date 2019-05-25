package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
import java.io.File;
import java.util.List;

/**
 * Interface to generate a DML script for a relational DBMS from an intermediate representation
 * of classes with hibernate annotations.
 */
public interface CodeGenerator {
    void generateCode(List<EntityData> interRep);
    void generateScript(List<EntityData> interRep, FileConfig fileConfig);
    List<String> getStatements();
}