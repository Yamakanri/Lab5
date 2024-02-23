package manager;

import command.Command;
import manager.validtor.*;
import model.*;
import utility.Printer;
import utility.RecursionException;
import utility.RecursionLimiter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class UserManager {
    private static final HashMap<String, Command> descriptionMap = CommandManager.getDescriptionMap();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean flag;
    static final HashSet<String> uniqueIDs = new HashSet<>();


    static {
        System.out.println("Приложение запущено!");
       flag = true;


    }

    public static boolean isRunning() {
        return flag;
    }

    public static void setIsInWork(boolean flag) {
        UserManager.flag = flag;
    }



    public static void requestInputCommand() {
        try {
            System.out.print("\nВведите команду: ");
            String line = scanner.nextLine().strip().replaceAll("\\s+", " ");
            // (\\s+) один или несколько символов пробела, табуляции, новой строки и тд
            checkAndStartCommand(line);
        } catch (NoSuchElementException ex) {
            System.out.println("Завершение программы!");
            setIsInWork(false);

        }
    }

    public static void requestCommandForScript(List<String> list) {
        try {
            for (String command : list) {
                command = command.replaceAll("\\s+", " ").trim().strip();
                System.out.println("\nСейчас выполняется команда " + command);
                RecursionLimiter.emerge();
                checkAndStartCommand(command);
            }
        } catch (StackOverflowError | RecursionException ex) {
            System.err.println("\nСкрипт вызывает сам себя! Выход из скрипта");
        }
    }
    public static void checkAndStartCommand(String line) {
        String argument;
        String command;
        String[] inputData = line.split(" ");

        if (inputData.length == 1) { //length() считает от единицы!!!
            argument = null;
            command = inputData[0].toLowerCase(); //пречек на то что пользователь вписал команду без заглавных
        } else if (inputData.length == 2) {
            command = inputData[0].toLowerCase();
            argument = inputData[1];
        } else {
            System.out.println("Команда/аргумент введены некорректно! Повторите попытку");
            return;
        }
        if (descriptionMap.containsKey(command)) { //проверка команды в карте команд
            descriptionMap.get(command).setArgs(argument);
            descriptionMap.get(command).execute(new Printer()); //запуск команды
        } else {
            System.out.println("Команды: " + inputData[0] + " – не существует! Для справки команд введите: \"help\" ");
        }
    }

    public static StudyGroup userDataCollect(StudyGroup studyGroup) {
        var userInput = "";


        /**
         * Method for generating collection id
         */

        studyGroup.setId(StudyGroup.getNextId());


        /**
         * Method for user input field Name in Person
         */
        String name = "";
        do {
            System.out.print("Введите имя студенческой группы: ");
            userInput = scanner.nextLine().strip();
            if (!EmptyChecker.checking(userInput)) {
                name = userInput;
            }
        }
        while (!NameValidator.validate(name));
        studyGroup.setName(name);

        /**
         * Method for user input field Y in Coordinates
         */
        Float x = null;
        do {

            System.out.print("Введите координату X типа (Float): ");
            userInput = scanner.nextLine().strip();
            try {
                if (!EmptyChecker.checking(userInput)) {
                    x = Float.parseFloat(userInput.replace(",", "."));
                }

                if (Float.parseFloat(userInput) > 1000000f) {
                    System.out.println("Координата должна быть меньше 1000000!");
                }
                if (Float.parseFloat(userInput) < -1000000f) {
                    System.out.println("Координата должна быть больше  -1000000!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!XCoordinateValidator.validate(x));

    /**
    * Method for user input field X in Coordinates
    */
        Long y = null;
        do {
            try {
                System.out.print("Введите координату Y типа (Long): ");
                userInput = scanner.nextLine().strip();
                if (!EmptyChecker.checking(userInput)) {
                    y = Long.parseLong(userInput);
                }
                if (Float.parseFloat(userInput) > 1000000) {
                    System.out.println("Координата должна быть меньше 1000000!");
                }
                if (Float.parseFloat(userInput) < -1000000) {
                    System.out.println("Координата должна быть больше -1000000!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!YCoordinateValidator.validate(y));
        studyGroup.setCoordinates(new Coordinates(x, y));


        /**
         * Method for generating time and date
         */
        studyGroup.setCreationDate(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        /**
         * Method for user input field StudentsCount in StudyGroup
         */
        int studentsCount = 0;
        do {
            try {
                System.out.print("\nВведите количество учеников: ");
                userInput = scanner.nextLine().strip();
                if (!EmptyChecker.checking(userInput)) {
                    studentsCount = Integer.parseInt(userInput);
                }
                if (Integer.parseInt(userInput) <= 0) {
                    System.out.println("Введите число (int) > 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!StudentsCountValidator.validate(studentsCount));
        studyGroup.setStudentsCount(studentsCount);


        /**
         * Method with user choice for field FormOfEducation in StudyGroup
         */
        FormOfEducation formOfEducation = null;
        do {
            System.out.print("\nВыберите форму обучения в группе и введите номер: \n");
            int i = 0;
            for (FormOfEducation form : FormOfEducation.values()) {
                System.out.println(++i + ". " + form);
            }
            try {
                userInput = scanner.nextLine().strip();
                Integer.parseInt(userInput);
                if (!EmptyChecker.checking(userInput)) {
                    if (FormOfEducation.valueOfEd(userInput) == null) {
                        System.out.println("Такого номера в списке нет! Попробуйте еще раз");
                    } else {
                        formOfEducation = FormOfEducation.valueOfEd(userInput);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Введите номер (число), чтобы выбрать тип обучения!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Невалидные данные! Попробуйте еще раз");
            }
        } while (!FormOfEducationValidator.validate(formOfEducation));
        studyGroup.setFormOfEducation(formOfEducation);

        /**
         * Method with user choice for field Semester in StudyGroup
         */
        Semester semester = null;
        do {
            System.out.print("\nВыберите семестр обучения группы и введите номер: \n");
            int i = 0;
            for (Semester quater : Semester.values()) {
                System.out.println(++i + ". " + quater);
            }
            try {
                userInput = scanner.nextLine().strip();
                Integer.parseInt(userInput);
                if (!EmptyChecker.checking(userInput)) {
                    if (Semester.valueOfSemester(userInput) == null) {
                        System.out.println("Такого номера в списке нет! Попробуйте еще раз");
                    } else {
                        semester = Semester.valueOfSemester(userInput);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Введите номер (число), чтобы выбрать семестр!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Невалидные данные! Попробуйте еще раз");
            }
        } while (!SemesterValidator.validate(semester));
        studyGroup.setSemester(semester);


        /**
         * Method for user input field Name in Person
         */


        Person student = new Person();

        String admin = "";
        do {
            System.out.print("\nВведите имя старосты: ");
            userInput = scanner.nextLine().strip();
            if (!EmptyChecker.checking(userInput)) {
                admin = userInput;
            } else {
                System.out.println("Невалидные данные! Попробуйте еще раз");
            }
        } while (!NameValidator.validate(admin));
        student.setName(admin);

        /**
         * Method for user input field Height in Person
         */
        int height = 0;
        do {
            try {
                System.out.print("\nВведите рост старосты: ");
                userInput = scanner.nextLine().strip();
                if (!EmptyChecker.checking(userInput)) {
                    height = Integer.parseInt(userInput);
                }
                if (Integer.parseInt(userInput) <= 0) {
                    System.out.println("Введите число (int) > 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!HeightValidator.validate(height));
        student.setHeight(height);


        /**
         * Method for user input field Weight in Person
         */
        double weight = 0;
        do {
            try {
                System.out.print("\nВведите вес старосты: ");
                userInput = scanner.nextLine().strip();
                if (!EmptyChecker.checking(userInput.replace(",", ",").trim().strip())) {
                    weight = Double.parseDouble(userInput);
                }
                if (Double.parseDouble(userInput) <= 0) {
                    System.out.println("Введите число (Double) > 0");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!WeightValidator.validate(weight));
        student.setWeight(weight);


        /**
         * Method for user input field PassportId in Person
         */
        String passportID = null;

        do {
            try {
                System.out.print("\nВведите passportID старосты: ");
                userInput = scanner.nextLine().strip();
                if (!EmptyChecker.checking(userInput) && !uniqueIDs.contains(userInput)) {
                    passportID = userInput;
                }
                if (userInput.length() >= 38) {
                    System.out.println("Введите паспорт короче 38 символов");
                }
                if(uniqueIDs.contains(userInput)) {
                    System.out.println("Паспорт уже используется!");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Невалидные данные! Попробуйте ввести еще раз");
            }
        } while (!PassportIDValidator.validate(passportID));
        uniqueIDs.add(passportID);


        student.setPassportID(passportID);

        /**
         * Method with user choice for field Country in Person
         */

        Country country = null;
        do {
            System.out.print("\nВыберите страну рождения старосты: \n");
            int i = 0;
            for (Country nation : Country.values()) {
                System.out.println(++i + ". " + nation);
            }
            try {
                userInput = scanner.nextLine().strip();
                Integer.parseInt(userInput);
                if (!EmptyChecker.checking(userInput)) {
                    if (Country.valueOfCountry(userInput) == null) {
                        System.out.println("Такого номера в списке нет! Попробуйте еще раз");
                    } else {
                        country = Country.valueOfCountry(userInput);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Введите номер (число), чтобы выбрать семестр!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Невалидные данные! Попробуйте еще раз");
            }
        } while (!SemesterValidator.validate(country));
        student.setNationality(country);

        studyGroup.setGroupAdmin(student);

        return studyGroup;
    }

}

