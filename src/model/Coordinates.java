package model;

import manager.validtor.XCoordinateValidator;
import manager.validtor.YCoordinateValidator;

/**
 * Model of Coordinates, contains getters/setter for fields of clas
 */
public class Coordinates {
    private Float x; //Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates(){

    }
    public Coordinates(Float x, Long y){
        this.x = x;
        this.y = y;
    }

    public void setX(Float x) {
        if (XCoordinateValidator.validate(x)) {
            this.x = x;
        }
    }

    public void setY(Long y) {
        if (YCoordinateValidator.validate(y)) {
            this.y = y;
        }
    }

    public Float getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
