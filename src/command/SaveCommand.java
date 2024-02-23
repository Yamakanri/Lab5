package command;

import manager.StudyGroupCollection;
import parse.CsvWriter;
import utility.Printer;

/**
 * Class contains implementation of print_ascending command
 * Save command in csv file on desktop
 */
public class SaveCommand extends Command {
    private StudyGroupCollection collectionManager;

    public SaveCommand(String description, boolean hasArgs) {
        super(description, hasArgs);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            CsvWriter csvWriter = new CsvWriter(new Printer(), collectionManager);
            csvWriter.write("/Users/sasha/Desktop/StudyGroup.csv");
        }
    }


    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды save нет аргументов! Попробуйте еще раз");
            return false;
        }
    }

    public void setCollectionManager(StudyGroupCollection collectionManager) {
        this.collectionManager = collectionManager;
    }
}
