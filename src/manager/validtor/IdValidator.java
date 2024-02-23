package manager.validtor;

/**
 * Contains validator for id.
 * Validates input value != null and value > 0
 */
public class IdValidator implements Validatable{
    public static boolean validate(Object value) {
        return value!= null && ((Integer) value) > 0;
    }
}
