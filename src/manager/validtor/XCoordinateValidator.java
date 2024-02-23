package manager.validtor;

/**
 * Contains validator for X coordinate
 * Validates input value != null and my check if value is between -1000000 and 100000
 */
public class XCoordinateValidator implements Validatable{
    public static boolean validate(Object value) {
        return (value!= null && (Float) value < 1000000f && (Float) value > -1000000f);
    }
}
