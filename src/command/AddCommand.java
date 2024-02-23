package command;

import manager.StudyGroupCollection;
import manager.UserManager;
import model.StudyGroup;
import utility.Printer;

/**
 * Class contains implementation of add command
 * Adds new element to collection
 */
public class AddCommand extends Command {
    public AddCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            StudyGroupCollection.addToCollection(UserManager.userDataCollect(new StudyGroup()));
            printer.print("Объект успешно добавлен в коллекцию!");
        }
    }


    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды add нет аргументов! Введите команду без аргументов!");
            return false;
        }
    }
}
