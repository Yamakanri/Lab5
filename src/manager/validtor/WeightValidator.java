package manager.validtor;

/**
 * Contains validator for weight
 * Validates input value != null and value > 0
 */
public class WeightValidator implements Validatable{

        public static boolean validate(Object value) {
            return value!= null && ((Double) value) > 0;
        }
}
