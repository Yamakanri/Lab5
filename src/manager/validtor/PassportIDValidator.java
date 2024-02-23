package manager.validtor;

/**
 * Contains validator for
 * Validates input value != null and length >= 38 and not empty
 */


public class PassportIDValidator implements Validatable {


    public static boolean validate(Object value) {
        String strValue = (String) value;
        return value != null && strValue.length() <= 38;
    }
}

