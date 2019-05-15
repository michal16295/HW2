package game.entities.sportsman;


import game.entities.MobileEntity;
import game.enums.Gender;
import utilities.ValidationUtils;

import java.awt.*;

/**
 * Sportsman class
 * Represents a mobile entity
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Sportsman extends MobileEntity implements Cloneable {
    private String name;
    private Double age;
    private Gender gender;
    private int id;
    private String color;

    /**
     * Ctor that creates a sportsman with parameters.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param maxSpeed     the maximum speed
     * @param acceleration the acceleration
     */
    public Sportsman(int id,String name, double age, Gender gender, double maxSpeed, double acceleration) {
        super(maxSpeed, acceleration);
        this.setAge(age);
        this.setGender(gender);
        this.setName(name);
        this.setId(id);

    }

    /**
     * default ctor
     * age: 12, gender: female, name: Daenrerys
     */
    public Sportsman(){
        this.setAge(12.0);
        this.setGender(Gender.FEMALE);
        this.setName("Daenrerys");
    }

    /**
     * Returns the name of sportsman.
     *
     * @return the name of sportsman
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of sportsman
     *
     * @param name the name
     */
    private void setName(String name) {
        ValidationUtils.assertNotNullOrEmptyString(name);
        this.name = name;
    }

    /**
     * Returns the age of sportsman.
     *
     * @return the age of sportsman
     */
    public Double getAge() {
        return age;
    }

    /**
     * Sets the age of sportsman.
     *
     * @param age the age
     */
    private void setAge(Double age) {
        ValidationUtils.assertNotNegative(age);
        this.age = age;
    }

    /**
     * Returns the gender of sportsman.
     *
     * @return the gender of sportsman
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of sportsman.
     *
     * @param gender the gender
     */
    private void setGender(Gender gender) {
        ValidationUtils.assertNotNull(gender);
        this.gender = gender;
    }

    /**
     * getting the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * stting the id
     * @param id new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getting the color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * setting the color
     * @param color new color
     */

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    /**
     * clone the original competitor
     * @return
     */
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    /**
     * upgrading the new clone we have created
     * @param id setting a new id
     * @param color setting a new color
     */
    public void upgrade(int id, String color){
        this.setId(id);
        this.setColor(color);
    }

    /**
     * @return sportsman name
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ' ' + getName() + getLocation();
    }

}
