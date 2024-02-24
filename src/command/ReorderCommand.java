package command;

import manager.StudyGroupCollection;
import utility.Printer;

import java.util.Collections;


/**
 * Class contains implementation of reorder command
 * Sort collection in reverse order
 */


public class ReorderCommand extends Command {
    public ReorderCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(printer, getArgs())) {
            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция пуста! Сортировать нечего");
            } else {
                Collections.reverse(StudyGroupCollection.getStudyGroupLinkedList());
                printer.print("Коллекция успешно отсортирована в обратном порядке!");
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды reorder нет аргументов! Введите команду без аргументов!");
            return false;
        }
    }
}




