package model;



/**
 * Model of Semester, contains getters/setter for fields of enum
 */


public enum Semester {
    FIRST("1"),
    SECOND("2"),
    THIRD("3"),
    FOURTH("4");

    public final String count;

    Semester(String count) {
        this.count = count;
    }

    public static Semester valueOfSemester(String quarter) {
        for (Semester value : values()) {
            if (value.count.equals(quarter)) {
                return value;
            }
        }
        return null;
    }
}

