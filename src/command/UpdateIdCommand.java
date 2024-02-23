package command;

import manager.StudyGroupCollection;
import manager.UserManager;
import model.StudyGroup;
import utility.Printer;


/**
 * Class contains implementation of print_ascending command
 * Update element by id
 */

public class UpdateIdCommand extends Command {

    public UpdateIdCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }



    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void execute(Printer printer) {
        int count = 0;
        if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
            printer.print("Коллекция пуста!");
        } else {
            if (checkArgument(new Printer(), getArgs())) {
                for (StudyGroup studyGroup : StudyGroupCollection.getStudyGroupLinkedList()) {
                    if (studyGroup.getId() == Long.parseLong(getArgs().toString())) {
                        count++;
                        studyGroup.updateElement(UserManager.userDataCollect(new StudyGroup()));
                    }
                }
                if (count == 0) {
                    printer.print("Элемента с id " + getArgs() + " не найдено!");
                }
            }
        }
    }

    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            printer.print("У команды update должен быть аргумент id (id элемента, значения которого вы хотите обновить). Попробуйте еще раз!");
            return false;
        } else {
            try {
                Integer.parseInt(getArgs().toString());
                return true;
            } catch (NumberFormatException ex) {
                printer.print("Команда update имеет аргумент типа (int). Попробуйте еще раз!");
                return false;
            }
        }
    }
}
