package manager.validtor;

/**
 * Contains validator for Y coordinate
 * Validates input value != null and my check if value > -1000000 and value < 100000
 */
public class YCoordinateValidator implements Validatable {
    public static boolean validate(Object value) {
        return (value!= null && (Long) value < 1000000L && (Long) value > -1000000L);
    }
}
