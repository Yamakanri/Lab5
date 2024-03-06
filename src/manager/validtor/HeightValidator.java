package manager.validtor;

public class HeightValidator implements Validatable {
    public static boolean validate(Integer value) {
        return value != null && value > 0;
    }
}