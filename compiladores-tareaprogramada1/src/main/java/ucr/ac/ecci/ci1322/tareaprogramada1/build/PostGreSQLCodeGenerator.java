package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Entity;
import java.util.List;

/**
 * Class that generates a DML for a PostgreSQL database from an intermediate representation classes
 * with hibernate annotations.
 * Implements the CodeGenerator interface.
 */
public class PostGreSQLCodeGenerator implements CodeGenerator {
    @Override
    public List<String> generateCode(List<Entity> interRep) {
        return null;
    }
    public void generateScript(List<Entity> interRep, String path, String name)  {

    };
}