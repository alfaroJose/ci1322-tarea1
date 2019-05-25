package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.ColumnData;
import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that build an intermediate representation of the classes with hibernate annotations
 * to be converted into a relational DB DML script.
 */
public class IRBuilder {
    private List<EntityData> interRep;

    public IRBuilder(List<EntityData> interRep) {
        this.interRep = interRep;
    }

    public IRBuilder() {
        this.interRep = new ArrayList<>();
    }

    /**
     * Method that parses a List of Classes with hibernate annotations into an intermediate representation
     * @param classes the list of classes
     * @return a list with all the entities that represents each class and their information.
     */
    public void parse(List<Class> classes)throws Exception{
        for( Class cl : classes ) {
            parseEntity(cl);
        }
        System.out.println("[INFO]Classes parsed to an intermediate representation");
    }

    public void parseEntity(Class temp)throws Exception{
        EntityData entityData = new EntityData();
        Entity entity = (Entity) temp.getAnnotation(Entity.class);
        if (entity != null){
            Table tabl = (Table) temp.getAnnotation(Table.class);
            if (tabl != null){
                if( tabl.name().equals("") )
                    entityData.setName(temp.getSimpleName());
                else
                    entityData.setName(tabl.name());
            }
            Field fields[] = temp.getDeclaredFields();
            ColumnData columnData;
            for( Field field : fields){
                columnData = new ColumnData();
                for( Annotation annotation : field.getAnnotations()){
                    if(annotation.annotationType().getSimpleName().equals("Id")){
                        Id id = field.getAnnotation(Id.class);
                        columnData.setId(true);
                    }
                    if(annotation.annotationType().getSimpleName().equals("Lob")){
                        Lob lob = field.getAnnotation(Lob.class);
                        columnData.setLob(true);
                    }
                    if(annotation.annotationType().getSimpleName().equals("Transient")){
                        Transient lob = field.getAnnotation(Transient.class);
                        columnData.setTransient(true);
                    }
                    if(annotation.annotationType().getSimpleName().equals("Column")){
                        Column column = field.getAnnotation(Column.class);
                        columnData.setName(column.name());
                        columnData.setType(field.getType().getSimpleName());
                        if(field.getType().getSimpleName().equals("String"))
                            columnData.setLength("" + column.length());
                        else if(field.getType().getSimpleName().equals("double") || field.getType().getSimpleName().equals("float"))
                            columnData.setPrecision("" + column.precision());
                        else if(field.getType().getSimpleName().equals("double") || field.getType().getSimpleName().equals("float"))
                            columnData.setPrecision("" + column.scale());
                        columnData.setNullable(column.nullable());
                    }
                }
                entityData.addColumnData(columnData);
            }
        }
        interRep.add(entityData);
    }

    public List<EntityData> getInterRep() {
        return interRep;
    }

    public void setInterRep(List<EntityData> interRep) {
        this.interRep = interRep;
    }
}