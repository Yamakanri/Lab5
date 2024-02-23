package manager;

import command.*;

import java.util.HashMap;

/**
 * Contains methods for storing, getting command instances
 */

public class CommandManager {
    private static final HashMap<String, Command> descriptionMap = new HashMap<>();
    static {
        descriptionMap.put("help", new HelpCommand("Команда выводит все доступные команды и их описание", false));
        descriptionMap.put("info", new InfoCommand("Команда выводит основную информацию о коллекции: тип, дата инициализации, количество элементов", false));
        descriptionMap.put("add", new AddCommand("Команда добавляет новый пользовательский элемент в коллекцию", false));
        descriptionMap.put("show", new ShowCommand("Команда выводит все элементы коллекции", false));
        descriptionMap.put("save", new SaveCommand("Команда сохраняет коллекцию в файл", true));
        descriptionMap.put("update", new UpdateIdCommand("Команда принимает id элеменета, которые находится в коллекции и обновляет его данные", true));
        descriptionMap.put("clear", new ClearCommand("Команда очищает коллекцию", false));
        descriptionMap.put("exit", new ExitCommand("Команда завершает программу без сохранения в файл", false));

        descriptionMap.put( "remove_by_id" , new RemoveByIdCommand("Команда удаляет элемент коллекции в соответсвии с его id" , true));
        descriptionMap.put( "remove_at" , new RemoveAtCommand("Команда удаляет  элемент в позиции, равной заданной", true));
        descriptionMap.put("remove_first", new RemoveFirstCommand("Команда удаляет первый элемент в коллекции", false));

        descriptionMap.put("reorder", new ReorderCommand("Команда сортирует коллекцию в обратном порядке", false));
        descriptionMap.put("print_ascending", new PrintAscCommand("Команда выводит все элементы коллекции в порядке возрастания", false));
        descriptionMap.put("filter_by_group_admin", new FilterByGroupAdminCommand("Команда выводит элементы, у которых значение поля groupAdmin – равно заданному", true));
        descriptionMap.put("filter_less_than_semester_enum", new FilterLessThanSemEnumCommand("Команда выводит элементы, у которых значение поля semesterEnum – меньше заданного", true));

        descriptionMap.put("execute_script", new ExecuteScriptCommand("Команда выполняет скрипт записанный в файле. Принимате путь файла как аргумент", true));
    }
    public static HashMap<String, Command> getDescriptionMap() {
        return descriptionMap;
    }


}
