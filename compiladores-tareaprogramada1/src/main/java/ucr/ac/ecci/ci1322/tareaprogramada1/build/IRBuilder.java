package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.EntityData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private IRValidator validator;

    public IRBuilder(List<EntityData> interRep, IRValidator validator) {
        this.interRep = interRep;
        this.validator = validator;
    }

    public IRBuilder() {
        this.interRep = new ArrayList<>();
        this.validator = new IRValidator();
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
                if( tabl.name().equals("") ) {
                    entityData.setName(temp.getSimpleName());
                }
                else {
                    entityData.setName(tabl.name());
                }
            }
        }

        Field fields[] = temp.getDeclaredFields();
        for( Field field : fields){
            for( Annotation annotation : field.getAnnotations()){
                Class<? extends Annotation> type = annotation.annotationType();
                System.out.println("Values of " + type.getSimpleName());


            }
        }

        parseColumns(temp);
        interRep.add(entityData);
    }

    public void parseColumns(Class temp){
        for (Field f: temp.getDeclaredFields()) {
            Column column = f.getAnnotation(Column.class);
            if (column != null)
                System.out.printf("[INFO]class: %s, column: %s%n" ,temp.getName(),column.name());
            if (f.isAnnotationPresent(Id.class))
                System.out.printf("[INFO]id field name: %s%n",f.getName());
        }
    }

    public List<EntityData> getInterRep() {
        return interRep;
    }

    public void setInterRep(List<EntityData> interRep) {
        this.interRep = interRep;
    }

    public IRValidator getValidator() {
        return validator;
    }

    public void setValidator(IRValidator validator) {
        this.validator = validator;
    }
}