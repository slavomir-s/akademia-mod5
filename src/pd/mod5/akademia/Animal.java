package pd.mod5.akademia;

import java.util.Objects;

public class Animal implements Speakable {
    @Override
    public void sound() {
        System.out.println("Metoda sound z Animal");
    }

    public enum Type{REPTILE,AMPHIBIAN,MAMMAL,FISH}
    private String name;
    private int yearOfBirth;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;

    private static int CURRENT_YEAR = 2022;

    public Animal(String name,int yearOfBirth,Type type){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.type = type;
    }
    public int getAge(){
        return CURRENT_YEAR - yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return yearOfBirth == animal.yearOfBirth && name.equals(animal.name) && type == animal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth, type);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", type=" + type +
                '}';
    }
}
