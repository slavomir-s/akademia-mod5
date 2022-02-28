package pd.mod5.akademia;
import java.util.List;
import java.util.ArrayList;

public class Zoo {
    private int yearOfEstablishment;
    private String name;
    private List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }
    public Zoo(String name,int yearOfEstablishment){
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        animals =new ArrayList();
    }
    public Zoo(String name,int yearOfEstablishment,List<Animal> animals){
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.animals =new ArrayList(animals);
    }
    public void showInfo(){
        System.out.println(String.format("Zoo \"%s\". Rok powstania: %d, średni wiek zwierząt %.1f miesięcy",this.name,this.yearOfEstablishment,this.avgAge()));
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    public void showAnimals(){
        for(Animal animal:animals)
            System.out.println(animal.toString());
    }
    public int countAnimals(){
        return animals.size();
    }
    private float avgAge(){
        float sumOfAnimalsAge = 0;
        for(Animal animal:animals)
            sumOfAnimalsAge+= animal.getAge();
        return (sumOfAnimalsAge)/animals.size();
    }
}
