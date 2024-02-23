package model;

/**
 * Enum of Country, contains getters/setter for fields of enum
 */
public enum Country {
    GERMANY("1"),
    VATICAN("2"),
    NORTH_KOREA("3");
    public final String country;
    Country(String country) {
        this.country = country;
    }

    public static Country valueOfCountry(String nationality) {
        for (Country value : values()) {
            if (value.country.equals(nationality)) {
                return value;
            }
        }
        return null;
    }
}
