package manager.validtor;


/**
 * Contains validator for nationality
 * Validates input value != null
 */
public class NationalityValidator implements Validatable{
    public static boolean validate(Object value) {
        return value!= null;
    }
}
