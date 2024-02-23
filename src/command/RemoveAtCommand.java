package command;

import manager.StudyGroupCollection;
import model.StudyGroup;
import utility.Printer;

/**
 * Class contains implementation of remove_at command
 * Deletes element from collection by index
 */
public class RemoveAtCommand extends Command {
    public RemoveAtCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
            printer.print("Коллекция пуста!");
        } else {
            if (checkArgument(new Printer(), getArgs())) {
                int index = Integer.parseInt(getArgs().toString());
                if (index >= 0 && index < StudyGroupCollection.getStudyGroupLinkedList().size()) {
                    StudyGroup removedGroup = StudyGroupCollection.getStudyGroupLinkedList().remove(index);
                    printer.print("Элемент с индексом " + index + " успешно удален из коллекции: " + removedGroup);
                } else {
                    printer.print("Неверный индекс! Попробуйте еще раз.");
                }
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            printer.print("У команды remove_at должен быть аргумент – индекс элемента коллекции!");
            return false;
        } else {
            try {
                int index = Integer.parseInt(getArgs().toString());
                if (index < 0 || index >= StudyGroupCollection.getStudyGroupLinkedList().size()) {
                    printer.print("Индекс выходит за пределы коллекции!");
                    return false;
                }
                return true;
            } catch (NumberFormatException ex) {
                printer.print("Команда remove_at принимает на вход в качестве аргумента только целые, неотрицательные числа!");
                return false;
            }
        }
    }
}
