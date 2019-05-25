package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that generates a DML for a PostgreSQL database from an intermediate representation classes
 * with hibernate annotations.
 * Implements the CodeGenerator interface.
 */
public class PostGreSQLCodeGenerator implements CodeGenerator {
    private List<String> statements;

    public PostGreSQLCodeGenerator() {
        statements = new ArrayList<>();
    }

    @Override
    public void generateCode(List<EntityData> interRep) {}

    public void generateScript(List<EntityData> interRep, FileConfig fileConfig)  { }

    public List<String> getStatements() {
        return statements;
    }
}