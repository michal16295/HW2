package game.entities.sportsman;


import game.entities.MobileEntity;
import game.enums.Gender;
import utilities.ValidationUtils;

/**
 * Sportsman class
 * Represents a mobile entity
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Sportsman extends MobileEntity {
    private String name;
    private Double age;
    private Gender gender;

    /**
     * Ctor that creates a sportsman with parameters.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param maxSpeed     the maximum speed
     * @param acceleration the acceleration
     */
    public Sportsman(String name, double age, Gender gender, double maxSpeed, double acceleration) {
        super(maxSpeed, acceleration);
        this.setAge(age);
        this.setGender(gender);
        this.setName(name);
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
     * @return sportsman name
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ' ' + getName();
    }

}
