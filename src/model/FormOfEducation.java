package model;


/**
 * Model of FormOfEducation, contains getters/setter for fields of enum
 */

public enum FormOfEducation {
    DISTANCE_EDUCATION("1"),
    FULL_TIME_EDUCATION("2"),
    EVENING_CLASSES("3");

    public final String form;

    FormOfEducation(String form) {
        this.form = form;
    }



    public static FormOfEducation valueOfEd(String label) {
        for (FormOfEducation value : values()) {
            if (value.form.equals(label)) {
                return value;
            }
        }
        return null;
    }
}
