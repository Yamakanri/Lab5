package command;

import manager.StudyGroupCollection;
import utility.Printer;


/**
 * Class contains implementation of remove_first command
 * Delete first element in collection
 */


public class RemoveFirstCommand extends Command {
    public RemoveFirstCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
            printer.print("Коллекция пуста!");
        } else {
            if (checkArgument(new Printer(), getArgs())) {
                StudyGroupCollection.getStudyGroupLinkedList().remove(0);
                printer.print("Первый элемент коллекции успешно удален!");

            }
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
