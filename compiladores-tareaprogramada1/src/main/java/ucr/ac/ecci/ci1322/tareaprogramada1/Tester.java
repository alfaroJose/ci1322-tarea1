package ucr.ac.ecci.ci1322.tareaprogramada1;

import ucr.ac.ecci.ci1322.tareaprogramada1.build.*;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.ColumnData;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        //Controller controller = new Controller();
        //controller.run();

        EntityData estudiantes = new EntityData();
        estudiantes.setName("estudiantes");

        ColumnData nombreE= new ColumnData();
        nombreE.setName("nombre");
        nombreE.setId(true);
        nombreE.setLength("50");
        nombreE.setType("String");


        ColumnData carnet= new ColumnData();
        carnet.setName("carnet");
        carnet.setLength("50");
        carnet.setNullable(false);
        carnet.setLob(true);


        List<ColumnData> colsE = new ArrayList<>();
        colsE.add(nombreE);
        colsE.add(carnet);

        estudiantes.setColumnDataList(colsE);


        EntityData cursos = new EntityData();
        cursos.setName("curso");

        ColumnData nombreC= new ColumnData();
        nombreC.setName("nombre");
        nombreC.setId(true);
        nombreC.setType("float");

        ColumnData creditos= new ColumnData();
        creditos.setName("creditos");
        creditos.setNullable(false);
        creditos.setType("int");

        List<ColumnData> colsC = new ArrayList<>();
        colsC.add(nombreC);
        colsC.add(creditos);

        cursos.setColumnDataList(colsC);

        List<EntityData> entidades = new ArrayList<>();
        entidades.add(estudiantes);
        entidades.add(cursos);

        IRBuilder irbuilder = new IRBuilder();
        irbuilder.setInterRep(entidades);

        Databases db = Databases.MYSQL;
        DBMSConfig dbconfig = new DBMSConfig("root", "password", "localhost", "3306", "automatas", Databases.MYSQL);

        MySQLConnector mysqlcon = new MySQLConnector();
        mysqlcon.createConnection(dbconfig);

        MySQLCodeGenerator mysqlcode = new MySQLCodeGenerator();
        mysqlcode.generateCode(irbuilder.getInterRep());
        mysqlcon.executeStatement(mysqlcode.getStatements());

        FileConfig fileconfig = new FileConfig("script.sql", "C:/Users/Andres/Desktop");

        mysqlcode.generateScript(irbuilder.getInterRep(), fileconfig);
    }
}