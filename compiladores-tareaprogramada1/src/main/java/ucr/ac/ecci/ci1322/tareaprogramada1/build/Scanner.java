package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that receives package names and check the classes with hibernate annotations to be processed.
 */
public class Scanner {
    private List<Class> classList;

    public Scanner(List<Class> classList) {
        this.classList = classList;
    }

    public Scanner() {
        this.classList = new ArrayList<>();
    }

    /**
     * Check the package to find classes with hibernate annotations
     * @param packageName the name of the package
     * @return a List with the classes with hibernate annotations
     */
    public void scan(String packageName){
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Entity.class));

        for (BeanDefinition bd : provider.findCandidateComponents(packageName)) {
            String name = bd.getBeanClassName();
            try {
                if(!classList.contains(Class.forName(name))) {
                    classList.add(Class.forName(name));

                    //System.out.println(Class.forName(name).getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //Print annotated column names
    public void printColumns(){
        for(Class cl : classList){
            for (Field f: cl.getDeclaredFields()) {
                Column column = f.getAnnotation(Column.class);
                if (column != null)
                    System.out.printf("class: %s, column: %s%n" ,cl.getName(),column.name());
                if (f.isAnnotationPresent(Id.class))
                {
                    System.out.printf("id field name: %s%n",f.getName());
                }
            }
        }

    }

    //Print annotated table names
    public void printTables(){
        for(Class cl : classList){
            //System.out.println(cl.getName());
            Table tabl = (Table) cl.getAnnotation(Table.class);
            if (tabl != null)
                System.out.printf("class: %s, table: %s%n" ,cl.getName(),tabl.name());
        }
    }

    public void printClasses(){
        System.out.println("Classes with hibernate annotations in the project package: ");
        for( Class cl : classList)
            System.out.println(cl.getName());
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }
}