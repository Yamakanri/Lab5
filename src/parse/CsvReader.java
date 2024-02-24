package parse;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import interfaces.BaseReader;
import manager.StudyGroupCollection;
import model.*;
import utility.Printer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * Class for Reading Collections from CSV files
 */
public class CsvReader implements BaseReader {
    private final Printer printer;

    public CsvReader(Printer printer) {
        this.printer = printer;
    }

    @Override
    public StudyGroup[] read(String path) {
        //не очень лаконично, зато практично
        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path)))) {
            String[] line;


            reader.readNext();

            while ((line = reader.readNext()) != null) {
                StudyGroup studyGroup = new StudyGroup();
                studyGroup.setId(Integer.parseInt(line[0]));
                studyGroup.setName(line[1]);

                // Создаем объект Coordinates и устанавливаем его значения
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Float.parseFloat(line[2]));
                coordinates.setY(Long.parseLong(line[3]));
                studyGroup.setCoordinates(coordinates);

                studyGroup.setCreationDate(LocalDateTime.parse(line[4]));
                studyGroup.setStudentsCount(Integer.parseInt(line[5]));
                studyGroup.setFormOfEducation(FormOfEducation.valueOf(line[6]));
                studyGroup.setSemester(Enum.valueOf(Semester.class, line[7]));

                // Создаем объект Person и устанавливаем его значения
                Person groupAdmin = new Person();
                groupAdmin.setName(line[8]);
                groupAdmin.setHeight(Integer.parseInt(line[9]));
                groupAdmin.setWeight(Double.parseDouble(line[10]));
                groupAdmin.setPassportID(line[11]);
                groupAdmin.setNationality(Country.valueOf(line[12]));


                studyGroup.setGroupAdmin(groupAdmin);

                StudyGroupCollection.getStudyGroupLinkedList().add(studyGroup);
            }
        } catch (FileNotFoundException e) {
            printer.print("Файл не найден или отсутствуют права на файл!");
        } catch (IOException e) {
            printer.print("Ошибка при чтении файла CSV!");
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return StudyGroupCollection.getStudyGroupLinkedList().toArray(new StudyGroup[0]);
    }
}
