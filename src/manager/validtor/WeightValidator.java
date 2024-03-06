package manager.validtor;

/**
 * Contains validator for weight
 * Validates input value != null and value > 0
 */
public class WeightValidator implements Validatable {

    public static boolean validate(Double value) {
        return value != null && value > 0;
    }
}