package command;


import manager.StudyGroupCollection;

import model.StudyGroup;
import utility.Printer;


import java.util.Comparator;

/**
 * Class contains implementation of print_ascending command
 * Outputs elements in collection in ascending order
 */
public class PrintAscCommand extends Command {
    public PrintAscCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция пуста! Сортировать нечего");
            } else {
                StudyGroupCollection.getStudyGroupLinkedList().sort(new SortById());
                printer.print("Коллекция успешно отсортирована!");
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды print_ascending не должно быть аргументов!");
            return false;
        }
    }

    public class SortById implements Comparator<StudyGroup> {

        @Override
        public int compare(StudyGroup o1, StudyGroup o2) {
            if (o1.getId() > o2.getId()) {
                return 1;
            } else if (o1.getId() == o2.getId()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}

