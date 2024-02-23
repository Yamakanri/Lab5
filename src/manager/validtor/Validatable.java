package manager.validtor;

/**
 * Common interface for all validators
 */
public interface Validatable {

    static boolean validate(Object value) {
        return false;
    }
}
