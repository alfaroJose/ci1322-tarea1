package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Column;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.Entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implements the CodeGenerator interface.
 */
public class MySQLCodeGenerator implements CodeGenerator {
    @Override
    public List<String> generateCode(List<Entity> interRep) {
        List<String> statements =  new ArrayList<>();
        for(Entity ent : interRep) {
            StringBuilder statement = new StringBuilder();
            statement.append("CREATE TABLE " + ent.getName() + " (");
            for(Column col: ent.getColumns()){
                statement.append(System.lineSeparator());
                statement.append("\t");
                statement.append(col.getName() + " " + "VARCHAR (100),");

            }
            statement.deleteCharAt(statement.length() -1); //borra ultima coma
            statement.append(");");
            statements.add(statement.toString());
        }
        return statements;
    }

    public void generateScript(List<Entity> interRep, String path, String name){
        StringBuilder script = new StringBuilder();
        for(Entity ent : interRep) {
            script.append("CREATE TABLE " + ent.getName() + " (");
            for(Column col: ent.getColumns()){
                script.append(System.lineSeparator());
                script.append("\t");
                script.append(col.getName() + " " + "VARCHAR (100),");
            }
            script.deleteCharAt(script.length() -1); //borra ultima coma
            script.append(");");
            script.append(System.lineSeparator());
            script.append(System.lineSeparator());
        }
        try{
            File file = new File(path, name);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(script.toString());
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}