package command;

import manager.CommandManager;
import utility.Printer;

import java.util.Map;


/**
 * Class contains implementation of help command
 * Output all the commands
 */


public class HelpCommand extends Command{
    public HelpCommand(String description, boolean hasArgs) {
        super(description, false);
    }

    @Override
    public void execute(Printer printer) {
        if (checkArgument(new Printer(), getArgs())) {
            int count = 1;
            for (Map.Entry<String, Command> command : CommandManager.getDescriptionMap().entrySet()) {
                printer.print(count++ + ". " + command.getKey() + " " + command.getValue().getDescription());
            }
        }
    }
    @Override
    public boolean checkArgument(Printer printer, Object inputArgs) {
        if (inputArgs == null) {
            return true;
        } else {
            printer.print("У команды help нет аргументов! Введите команду без аргументов!");
            return false;
        }
    }


}
