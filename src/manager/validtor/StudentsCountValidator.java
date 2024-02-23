package manager.validtor;

/**
 * Contains validator for semester count
 * Validates input value != null and value > 0
 */
public class StudentsCountValidator implements Validatable{
    public static boolean validate(Object value) {
        return value!= null && ((Integer) value) > 0;
    }
}
