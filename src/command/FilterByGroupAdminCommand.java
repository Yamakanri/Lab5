package command;

import manager.StudyGroupCollection;
import model.StudyGroup;
import utility.Printer;

/**
 * Class contains implementation of filter_by_group_admin command
 * Outputs elements of collection contains same group admin
 */
public class FilterByGroupAdminCommand extends Command {

    public FilterByGroupAdminCommand(String description, boolean hasArgs) {super(description, hasArgs);}

    @Override
    public void execute(Printer printer) {

        if (checkArgument(new Printer(), getArgs())) {
            boolean found = false;
            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция пуста!");
            } else {
                for (StudyGroup studyGroup : StudyGroupCollection.getStudyGroupLinkedList()) {

                    if (studyGroup.getGroupAdmin().getName().equals(getArgs().toString())) {
                        System.out.println(studyGroup);
                        found = true;
                    }

                }
                if (!found) {
                    printer.print("Элемента коллекции с таким старостой не найдено");
                }
            }
        }
    }
    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            printer.print("У команды filter_starts_with_name должен быть аргумент!");
            return false;
        } else {
            return true;
        }
    }
}

