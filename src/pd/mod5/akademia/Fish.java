package pd.mod5.akademia;
import java.util.List;
import java.util.ArrayList;

public class Fish extends Animal{
    public Fish(String name,int yearOfBirth,FoodValue value,List<Habitat> habitats,int numberOfFins){
        super(name,yearOfBirth,Type.FISH);
        this.foodValue = value;
        this.habitats = new ArrayList<>(habitats);
        this.numberOfFins = numberOfFins;
    }
    @Override
    public void sound() {
        System.out.println("Metoda sound z Fish");
    }
    public enum Habitat {River, Lake, Sea,Ocean}

    public enum FoodValue{Poor,Good,Excellent}

    public FoodValue getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(FoodValue foodValue) {
        this.foodValue = foodValue;
    }

    private FoodValue foodValue;

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    private List<Habitat> habitats;

    public int getNumberOfFins() {
        return numberOfFins;
    }

    public void setNumberOfFins(int numberOfFins) {
        this.numberOfFins = numberOfFins;
    }

    private int numberOfFins;


}
