package ucr.ac.ecci.ci1322.tareaprogramada1;

import ucr.ac.ecci.ci1322.tareaprogramada1.build.*;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.ColumnData;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try{
            controller.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}