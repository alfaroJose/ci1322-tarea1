package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.ColumnData;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
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
    private List<String> statements;

    public MySQLCodeGenerator() {
        statements = new ArrayList<>();
    }

    @Override
    public List<String> generateCode(List<EntityData> interRep) {
        for(EntityData ent : interRep) {
            StringBuilder statement = new StringBuilder();
            statement.append("CREATE TABLE " + ent.getName() + " (");
            for(ColumnData col: ent.getColumnDataList()){
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

    public void generateScript(List<EntityData> interRep, FileConfig fileConfig){
        StringBuilder script = new StringBuilder();
        for(EntityData ent : interRep) {
            script.append("CREATE TABLE " + ent.getName() + " (");
            for(ColumnData col: ent.getColumnDataList()){
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
            File file = new File(fileConfig.getFilePath(), fileConfig.getFileName());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(script.toString());
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<String> getStatements() {
        return statements;
    }
}