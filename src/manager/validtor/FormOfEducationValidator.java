package manager.validtor;

/**
 * Contains validator for form of education.
 * Validates input value != null
 */
public class FormOfEducationValidator implements Validatable{
    public static boolean validate(Object value){
        return value!= null;
    }
}
