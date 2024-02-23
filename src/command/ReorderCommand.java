package command;

import manager.StudyGroupCollection;
import utility.IdSort;
import utility.Printer;



/**
 * Class contains implementation of reorder command
 * Sort collection in reverse order
 */


public class ReorderCommand extends Command {
    public ReorderCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {


            if (StudyGroupCollection.getStudyGroupLinkedList().isEmpty()) {
                printer.print("Коллекция пуста! Сортировать нечего");

            } else {
                StudyGroupCollection.getStudyGroupLinkedList().sort(new IdSort());
                printer.print("Коллекция успешно отсортирована!");
            }

        }
    }


        public boolean checkArgument (Printer printer, Object inputArgs){
            if (inputArgs == null) {
                return true;
            } else {
                printer.print("У команды add нет аргументов! Введите команду без аргументов!");
                return false;
            }
        }



    }

