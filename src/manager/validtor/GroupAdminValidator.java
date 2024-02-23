package manager.validtor;

/**
 * Contains validator for group admin.
 * Validates input value != null
 */
public class GroupAdminValidator implements Validatable{
    public static boolean validate(Object value) {
        return value!= null;
    }
}
