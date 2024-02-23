package manager.validtor;

/**
 * Contains validator for semester
 * Validates input value != null
 */
public class SemesterValidator implements Validatable{
    public static boolean validate(Object value) {
        return value!= null;
    }
}
