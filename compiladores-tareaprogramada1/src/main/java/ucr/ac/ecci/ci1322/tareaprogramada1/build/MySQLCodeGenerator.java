package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.ColumnData;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    /**
     * Populate List<String> statements with mysql statements to create each Entity and its Columns
     */
    @Override
    public void generateCode(List<EntityData> interRep) {
        for(EntityData ent : interRep) {
            StringBuilder statement = new StringBuilder();
            statement.append("CREATE TABLE " + ent.getName() + " ("); //table name
            for(ColumnData col: ent.getColumnDataList()){
                statement.append(System.lineSeparator());
                statement.append(col.getName() + " "); //column name
                if(col.isLob())
                    statement.append("BLOB");
                else if(col.getType() == "String")
                    statement.append(castType(col.getType()) + "(" + col.getLength() + ")"); //cast to MYSQL types
                else
                    statement.append(castType(col.getType()));
                if(!col.isNullable())
                    statement.append(" NOT NULL");
                statement.append(","); //column separator
                if(col.isId()){
                    statement.append("PRIMARY KEY (" + col.getName() + "),");
                }
            }
            statement.deleteCharAt(statement.length() -1); //delete last comma
            //statement.append(System.lineSeparator());
            statement.append(");");
            statements.add(statement.toString());
        }
    }

    /**
     * Populate MYSQL script file with statements to create each Entity and its Columns
     * with corresponding file name and path according to fileConfig.
     * @param interRep
     * @param fileConfig
     */
    public void generateScript(List<EntityData> interRep, FileConfig fileConfig){
        StringBuilder script = new StringBuilder();
        for(EntityData ent : interRep) {
            script.append("CREATE TABLE " + ent.getName() + " (");
            for(ColumnData col: ent.getColumnDataList()){
                script.append(System.lineSeparator());
                script.append("\t");
                script.append(col.getName() + " "); //column name
                if(col.isLob())
                    script.append("BLOB");
                else if(col.getType() == "String")
                    script.append(castType(col.getType()) + "(" + col.getLength() + ")");
                else
                    script.append(castType(col.getType()));
                if(!col.isNullable())
                    script.append(" NOT NULL");
                script.append(","); //column separator
                if(col.isId()){
                    script.append(System.lineSeparator());
                    script.append("\t");
                    script.append("PRIMARY KEY (" + col.getName() + "),");
                }
            }
            script.deleteCharAt(script.length() -1); //delete last comma
            script.append(System.lineSeparator());
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

    /**
     * Returns the MYSQL equivalent data type for java types
     * @param type
     * @return newtype
     */
    public String castType(String type){
        String newtype = "";
        switch (type){
            case "String":
                newtype = "VARCHAR";
                break;
            case "char":
                newtype = "CHAR";
                break;
            case "int":
                newtype = "INT";
                break;
            case "float":
                newtype = "FLOAT";
                break;
            case "double":
                newtype = "DOUBLE";
                break;
        }
        return newtype;
    }
}