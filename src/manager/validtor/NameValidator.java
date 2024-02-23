package manager.validtor;

/**
 * Contains validator for name
 * Validates input value != null
 */
public class NameValidator implements Validatable{
    public static boolean validate(Object value) {
        return value != null && !((String) value).isEmpty();
    }
}

