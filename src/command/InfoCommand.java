package command;


import manager.StudyGroupCollection;
import utility.Printer;


/**
 * Class contains implementation of info command
 * Outputs basic information about elements in collection
 */


public class InfoCommand extends Command {
    public InfoCommand(String description, boolean hasArgs) {
        super(description, false);
    }
        @Override
        public void execute(Printer printer) {
            if (checkArgument(new Printer(), getArgs())) {
                printer.print("Тип коллекции:" + StudyGroupCollection.getStudyGroupLinkedList().getClass().getSimpleName());
                printer.print("Дата создания:" + StudyGroupCollection.getCreationDate());
                printer.print("Количество групп:" + StudyGroupCollection.getStudyGroupLinkedList().size());
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
