package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Entity;

import java.io.File;
import java.util.List;

/**
 * Interface to generate a DML script for a relational DBMS from an intermediate representation
 * of classes with hibernate annotations.
 */
public interface CodeGenerator {
    List<String> generateCode(List<Entity> interRep);
    void generateScript(List<Entity> interRep, String path, String name);
}