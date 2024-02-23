package model;

import manager.validtor.*;


/**
 * Model of Person, contains getters/setter for fields of class
 */
public class Person {

    private String name; //Поле не может быть null, Строка не может быть пустой

    private int height; //Поле не может быть null

    private Double weight; //Поле может быть null, Значение поля должно быть больше 0

    private String passportID; //Длина строки не должна быть больше 38, Строка не может быть пустой, Значение этого поля должно быть уникальным, Поле не может быть null

    private Country nationality; //Поле может быть null

    public Person() {
    }

    public Person(String name, int height,Double weight, String passportID, Country nationality) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
        this.nationality = nationality;
    }


    public void setName(String name) {
        if (NameValidator.validate(name)) {
            this.name = name;
        }
    }

    public void setHeight(int height) {
        if (HeightValidator.validate(height)) {
            this.height = height;
        }
    }

    public void setWeight(Double weight) {
        if (WeightValidator.validate(weight)) {
            this.weight = weight;
        }
    }

    public void setPassportID(String passportID) {
        if (PassportIDValidator.validate(passportID)) {
            this.passportID = passportID;
        }
    }

    public void setNationality(Country nationality) {
        if (NationalityValidator.validate(nationality)) {
            this.nationality = nationality;
        }
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public String getPassportID() {
        return passportID;
    }

    public Country getNationality() {
        return nationality;
    }


}
