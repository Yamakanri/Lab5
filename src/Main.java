import manager.StudyGroupCollection;
import manager.UserManager;
import parse.CsvReader;
import utility.Printer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static  String FILE_PATH = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("–––––––– " + LocalDateTime.now().toString().substring(0, 10) + " ––––––––");
        System.out.println("Введите путь к файлу или нажмите Enter чтобы продолжить");
        String userInp = scanner.nextLine();
        if (userInp == null){
            System.out.println("\n");
        }else{
            FILE_PATH = userInp;
        }
        CsvReader csvReader = new CsvReader(new Printer());

        StudyGroupCollection studyGroupCollection = new StudyGroupCollection(csvReader.read(FILE_PATH), FILE_PATH);
        while (UserManager.isRunning()) {
            UserManager.requestInputCommand();
        }
    }
}
