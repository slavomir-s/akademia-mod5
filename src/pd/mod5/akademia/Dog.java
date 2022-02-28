package pd.mod5.akademia;

public class Dog extends Animal{
    public Dog(String name,int yearOfBirth,Breed breed,Size size){
        super(name,yearOfBirth, Type.MAMMAL);
        this.breed = breed;
    }

    @Override
    public void sound() {
        System.out.println("Metoda sound z Dog");
    }

    public enum Size{SMALL,MEDIUM,BIG}

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    private Size size;

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    private Breed breed;

    public enum Breed{ Akita,Bulldog,Beagle,Boxer,Doberman,Chihuahua}
}
