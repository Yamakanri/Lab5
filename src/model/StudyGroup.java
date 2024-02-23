package model;


import manager.validtor.*;

import java.time.LocalDateTime;

/**
 * Model of StudyGroup, contains getters/setter for fields of closs and methods to change fields
 */

public class StudyGroup {

    private static int nextId = 1;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semester; //Поле не может быть null

    private Person groupAdmin; //Поле может быть null

    public StudyGroup(){

    }

    public StudyGroup(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Integer studentsCount,
                      FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin){
        this.setName(name);
        this.setId(id);
        this.coordinates = coordinates != null ? coordinates : new Coordinates(); // инициализация coordinates
        this.setCreationDate(creationDate);
        this.setStudentsCount(studentsCount);
        this.setFormOfEducation(formOfEducation);
        this.setSemester(semesterEnum);
        this.setGroupAdmin(groupAdmin);
    }


    public void updateElement(StudyGroup studyGroup) {
        setName(studyGroup.getName());
        setId(getNextId());
        setCoordinates(studyGroup.getCoordinates());
        setCreationDate(studyGroup.getCreationDate());
        setCreationDate(studyGroup.getCreationDate());
        setFormOfEducation(studyGroup.getFormOfEducation());
        setSemester(studyGroup.getSemester());
        setGroupAdmin(studyGroup.getGroupAdmin());
    }
    public void setId(Integer id) {
        if (IdValidator.validate(id)) {
            this.id = nextId;
            nextId++;
        }
    }
    public void setName(String name) {
        if (NameValidator.validate(name)) {
            this.name = name;
        }
    }



    public void setCoordinates(Coordinates coordinates) {
        if (XCoordinateValidator.validate(coordinates.getX()) && YCoordinateValidator.validate(coordinates.getY())) {
            this.coordinates = coordinates;
        }
    }

    public void setStudentsCount(Integer studentsCount) {
        if (StudentsCountValidator.validate(studentsCount)) {
            this.studentsCount = studentsCount;
        }
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        if (FormOfEducationValidator.validate(formOfEducation)) {
            this.formOfEducation = formOfEducation;
        }
    }

    public void setSemester(Semester semester) {
        if (SemesterValidator.validate(semester)) {
            this.semester = semester;
        }
    }

    public void setGroupAdmin(Person groupAdmin) {
        if (GroupAdminValidator.validate(groupAdmin)) {
            this.groupAdmin = groupAdmin;
        }
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public static Integer getNextId() {
        return nextId;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemester() {
        return semester;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }



    public String toString() {
        return "---------\n" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "coordinates: (" + coordinates.getX() + ", " + coordinates.getY() + ")" + "\n" +
                "creationDate: " + creationDate + "\n" +
                "studentsCount: " + studentsCount + "\n" +
                "formOfEducation: " + formOfEducation + "\n" +
                "semester: " + semester + "\n" +
                "groupAdmin: " + groupAdmin.getName() + "\n" +
                "adminHeight: " + groupAdmin.getHeight() + "\n" +
                "adminWeight: " + groupAdmin.getWeight() + "\n" +
                "passportID: " + groupAdmin.getPassportID() + "\n" +
                "adminNationality: " + groupAdmin.getNationality() + "\n";

    }
}
