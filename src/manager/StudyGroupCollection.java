package manager;

import manager.validtor.*;
import model.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Contains tools for operation StudyGroup collection
 */

public class StudyGroupCollection {
    private static LocalDateTime creationDate;
    private static StudyGroup[] studyGroupArray;
    private static final LinkedList<StudyGroup> studyGroupLinkedList = new LinkedList<>();
    private static String path;

    public StudyGroupCollection(StudyGroup[] studyGroupArray, String path) {
        StudyGroupCollection.studyGroupArray = studyGroupArray;
        creationDate =LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        StudyGroupCollection.path = path;
    }



    private static final HashSet<Number> idCollection = new HashSet<>();

    /**
     * Method for validation input values and adding to collection new objects from file
     * @param studyGroup
     */

    public static void validateAndAddToCollection(StudyGroup studyGroup) {
        if (idCollection.contains(studyGroup.getId())) {
            System.out.println("Объект с id" + studyGroup.getId() + " уже существует! Объект не добавлен в коллекцию");
            return;
        }
        idCollection.add(studyGroup.getId());
        if (IdValidator.validate(studyGroup.getId()) && NameValidator.validate(studyGroup.getName())
                && XCoordinateValidator.validate(studyGroup.getCoordinates().getX())
                && YCoordinateValidator.validate(studyGroup.getCoordinates().getY()) && FormOfEducationValidator.validate(studyGroup.getFormOfEducation())
                && GroupAdminValidator.validate(studyGroup.getGroupAdmin()) && SemesterValidator.validate(studyGroup.getSemester())) {
            addToCollection(studyGroup);
        } else {
            System.out.println("Объект под индексом " + studyGroup.getId() + " имеет некорректные поля! Объект не будет загружен в коллекцию");
        }
    }

    /**
     * Method for adding new objects to collection via add command
     * @param studyGroup
     */
    public static void addToCollection(StudyGroup studyGroup) {
        studyGroupLinkedList.add(studyGroup);
    }



    /**
     * Getters for collection
     * @return
     */
    public static LocalDateTime getCreationDate() {
        return creationDate;
    }

    public static LinkedList<StudyGroup> getStudyGroupLinkedList() {
        return studyGroupLinkedList;
    }
}


