package ucr.ac.ecci.ci1322.tareaprogramada1.build;

/**
 * Class that runs some validations in the intermediate representation to check if it's a valid one.
 */
public class IRValidator {

    public IRValidator() {
    }

    public boolean checkAnnotations(){
        return true;
    }

    /**
     * Method that checks if the IR have cycles in their entities.
     * @return true id there are cycles, false otherwise.
     */
    public boolean checkCycles(){
        return true;
    }

    public boolean checkSupportedAnnotations(){
        return true;
    }
}
