package game.entities.sportsman;


import game.entities.MobileEntity;
import game.enums.Gender;
import utilities.ValidationUtils;

public class Sportsman extends MobileEntity {
    private String name;
    private Double age;
    private Gender gender;

    public Sportsman(String name, double age, Gender gender, double maxSpeed, double accelaration){
        super(maxSpeed, accelaration);
        this.setAge(age);
        this.setGender(gender);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        ValidationUtils.assertNotNullOrEmptyString(name);
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    private void setAge(Double age) {
        ValidationUtils.assertNotNegative(age);
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        ValidationUtils.assertNotNull(gender);
        this.gender = gender;
    }
}
