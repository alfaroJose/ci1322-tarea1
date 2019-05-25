package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
import java.io.File;
import java.util.List;

/**
 * Interface to generate a DML script for a relational DBMS from an intermediate representation
 * of classes with hibernate annotations.
 */
public interface CodeGenerator {
    /**
     * Method that generates the SQL code from a intermediate representation.
     * @param interRep the intermediate representation of the classes with hibernate annotations
     */
    void generateCode(List<EntityData> interRep);
    /**
     * Method that generates s SQL script from an intermediate representation and stores in a file and file path given
     * @param interRep the intermediate representation of the classes with hibernate annotations
     * @param fileConfig the file configuration
     */
    void generateScript(List<EntityData> interRep, FileConfig fileConfig);
    /**
     * Method that returns the SQL statements generated
     * @return a list with the SQL statements generated
     */
    List<String> getStatements();
}