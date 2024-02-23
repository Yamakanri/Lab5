package manager;


/**
 * Contains checking empty values
 */

public class EmptyChecker {
    public static boolean checking(String userInput) {
        if (userInput.isEmpty()) {
            System.out.println("Поле не может быть пустым! Попробуйте еще раз");
            return true;
        } else {
            return false;
        }
    }
}
