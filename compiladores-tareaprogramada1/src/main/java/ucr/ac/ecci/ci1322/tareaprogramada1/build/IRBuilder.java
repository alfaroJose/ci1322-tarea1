package ucr.ac.ecci.ci1322.tareaprogramada1.build;

import ucr.ac.ecci.ci1322.tareaprogramada1.model.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that build an intermediate representation of the classes with hibernate annotations
 * to be converted into a relational DB DML script.
 */
public class IRBuilder {
    private List<Entity> interRep;
    private IRValidator validator;

    public IRBuilder(List<Entity> interRep, IRValidator validator) {
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
    public List<Entity> parse(List<Class> classes){
        return interRep;
    }

    public List<Entity> getInterRep() {
        return interRep;
    }

    public void setInterRep(List<Entity> interRep) {
        this.interRep = interRep;
    }

    public IRValidator getValidator() {
        return validator;
    }

    public void setValidator(IRValidator validator) {
        this.validator = validator;
    }
}