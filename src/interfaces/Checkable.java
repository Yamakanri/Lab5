package interfaces;

import utility.Printer;
/**
 * Basic check for commands and arguments.
 */
public interface Checkable {
    boolean checkArgument(Printer printer, Object inputArgs);
}
