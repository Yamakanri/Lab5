package command;

import interfaces.Checkable;
import interfaces.Executable;
import utility.Printer;


public abstract class Command implements Executable, Checkable {
    private final String description;
    private final boolean hasArgs;
    private Object args;


    public Command(String description, boolean hasArgs) {
        this.description = description;
        this.hasArgs = hasArgs;

    }

    @Override
    public abstract void execute(Printer printer);



    @Override
    public abstract boolean checkArgument(Printer printer, Object inputArgs);


    public boolean isHasArgs() {
        return hasArgs;
    }


    public String getDescription() {
        return description;
    }


    public Object getArgs() {
        return args;
    }


    public void setArgs(Object args) {
        this.args = args;
    }


}
