package command;

import manager.StudyGroupCollection;
import utility.Printer;


/**
 * Class contains implementation of clear command
 * Clears all collection
 */


public class ClearCommand extends Command {
    public ClearCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция уже пустая");
            } else {
                StudyGroupCollection.getStudyGroupLinkedList().clear();
                printer.print("Коллекция очищена!");
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды clear нет аргументов!");
            return false;
        }
    }
}
