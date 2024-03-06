package parse;

import com.opencsv.CSVWriter;
import interfaces.BaseWriter;
import manager.StudyGroupCollection;
import model.StudyGroup;
import utility.Printer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Class for Writing Collections to CSV files
 */

public class CsvWriter implements BaseWriter {
    private final Printer printer;
    private final StudyGroupCollection collectionManager;

    public CsvWriter(Printer printer, StudyGroupCollection collectionManager) {
        this.printer = printer;
        this.collectionManager = collectionManager;
    }


    public void write(String path) {
        //честно, мне не нравится как это выглядит, но решения лаконичнее я не нашел. Тут есть нужный BufferedOutputStream
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(path))))) {
            List<StudyGroup> studyGroups = StudyGroupCollection.getStudyGroupLinkedList();

            String[] headers = {
                    "ID",
                    "Название",
                    "X координата",
                    "Y координата",
                    "Дата создания",
                    "Количество студентов",
                    "Форма обучения",
                    "Семестр",
                    "Имя старосты",
                    "Рост старосты",
                    "Вес старосты",
                    "Паспорт ID",
                    "Национальность"

            };
            writer.writeNext(headers);
            for (StudyGroup studyGroup : studyGroups) {
                String nationalityString = studyGroup.getGroupAdmin().getNationality() != null ? studyGroup.getGroupAdmin().getNationality().toString() : "";
                String[] record = {
                        String.valueOf(studyGroup.getId()),
                        studyGroup.getName(),
                        String.valueOf(studyGroup.getCoordinates().getX()),
                        String.valueOf(studyGroup.getCoordinates().getY()),
                        studyGroup.getCreationDate().toString(),
                        String.valueOf(studyGroup.getStudentsCount()),
                        studyGroup.getFormOfEducation().toString(),
                        studyGroup.getSemester().toString(),
                        studyGroup.getGroupAdmin().getName(),
                        String.valueOf(studyGroup.getGroupAdmin().getHeight()),
                        String.valueOf(studyGroup.getGroupAdmin().getWeight()),
                        studyGroup.getGroupAdmin().getPassportID(),
                        nationalityString
                };
                writer.writeNext(record);
            }
            printer.print("Коллекция успешно сохранена в CSV файле.");
        } catch (IOException e) {
            printer.print("Ошибка при записи в файл CSV!");
        }
    }
}
