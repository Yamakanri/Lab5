package command;

import manager.StudyGroupCollection;
import model.StudyGroup;
import utility.Printer;


/**
 * Class contains implementation of show command
 * Show all elements in collection
 */
public class ShowCommand extends Command {

    public ShowCommand(String description, boolean hasArgs) {
        super(description, false);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция пуста!");
            } else {
                for (StudyGroup studyGroup : StudyGroupCollection.getStudyGroupLinkedList()) {
                    System.out.println(studyGroup.toString());
                }
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды show нет аргументов!");
            return false;
        }
    }
}
