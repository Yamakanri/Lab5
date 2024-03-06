package command;

import manager.StudyGroupCollection;
import model.StudyGroup;
import utility.Printer;


/**
 * Class contains implementation of filter_less_than_semester command
 * Outputs elements of collection which has less than specified semester
 */

public class FilterLessThanSemEnumCommand extends Command {
    public FilterLessThanSemEnumCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }


    public void execute(Printer printer) {
        try {
            if (checkArgument(new Printer(), getArgs())) {
                if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                    printer.print("Коллекция пуста!");
                } else {

                    int argumentSemester = Integer.parseInt(getArgs().toString()) - 1;

                    for (StudyGroup studyGroup : StudyGroupCollection.getStudyGroupLinkedList()) {
                        if (argumentSemester > (studyGroup.getSemester().ordinal())) {
                            printer.print("Группа: " + studyGroup.getName());

                        }

                    }

                }
            }
        }catch (NumberFormatException ex){
            System.out.println("Неправильный аргумент! Попробуйте ввести семестр в числовом виде!");
        }
    }


    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null || Integer.parseInt((String) inputArgs)>3 || Integer.parseInt((String) inputArgs)<0) {
            printer.print("У команды filter_less_than_sem должен быть положительный аргумент меньше 3!");
            return false;
        } else {
            return true;
        }
    }

}


