package manager.validtor;


/**
 * Contains validator for height.
 * Validates input value != null and value > 0
 */

public class HeightValidator implements Validatable{
    public static boolean validate(Object value) {
        return ((Integer)value>0);
    }

}
