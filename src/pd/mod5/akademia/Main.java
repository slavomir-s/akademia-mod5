package pd.mod5.akademia;



import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        int val_integer = 250;
        String val_string = "Akademia jest super !";
        double val_double = 1.234555;

        System.out.println("Zmienna val_integer ma wartość " + val_integer);
        System.out.println("Zmienna val_string ma wartość " + val_string);
        System.out.println(String.format("Zmienna val_double ma wartość %f",val_double));
        System.out.println("Zmienna val_double ma wartość " + val_double);

        int [] tablica = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int liczba:tablica)
            System.out.println(liczba%2==0 ? String.format("Liczba %d jest parzysta",liczba): liczba);

        int value = 1;
        int sum = 0;
        while(value<500){
            sum+=value++;
        }
        System.out.println("Suma liczb od 1 do 500 to "+sum);

        switch(countGrade(new int[]{10,2,2,3,4,5,6,7,2,3,4,2,3})){
            case 'A':
                System.out.println("Super");
                break;
            case 'B':
                System.out.println("Srednio");
                break;
            case 'C':
                System.out.println("Slabo");
                break;
            default:
                System.out.println("Cos nie tak...");
        }

        double [] positiveValues = changeToPositiveValueOnly(new double[]{-1.123,12.1,11,5,-2,-0.2});
        for(double positiveElement : positiveValues)
            System.out.println(positiveElement);

        String[] names = new String[]{"Witold","Agnieszka","Alicja","Ryszard","EwA","Janusz"};
        for(String name:names)
            System.out.println(name +" is a "+getGenderByName(name));
        //zadanie z ZOO
        zooTasks();

        System.out.println("Koniec PD mod 5");


    }
    public static char countGrade(int[] tab){
        int sum = 0;
        for(int element:tab)
            sum+=element;
        float avg = (float)sum/tab.length;
        System.out.println(String.format("Liczba elementów: %d, suma liczb: %d, wartość średniej: %f",tab.length,sum,avg));
        if(avg>=4)
            return 'A';
        else if(avg<4 && avg>=3)
            return 'B';
        else
            return 'C';
    }

    public static double[] changeToPositiveValueOnly(double [] tab){
        double [] outTab = new double[tab.length];
        for(int i =0; i<tab.length; i++){
            outTab[i] = tab[i]<0 ? (-1)*tab[i] : tab[i];
        }
        return outTab;
    }

    public enum gender{
        MAN,WOMAN
    }

    public static gender getGenderByName(String name){
        if( name.toLowerCase().charAt(name.length()-1) =='a')//są wyjątki od tej zasady
            return gender.WOMAN;
        return gender.MAN;
    }

    public static void zooTasks(){
        Zoo zoo = new Zoo("Północne",1990);

        //generacja zwierząt:

        int numberOfAnimals = 18;
        Random randomAge = new Random();
        for(int i =0;i<numberOfAnimals;i++)
        {
           zoo.addAnimal(new Animal("AnimalNo_"+i,randomAge.nextInt(1980,2022), (i%2==0) ? Animal.Type.AMPHIBIAN : Animal.Type.REPTILE));
        }
        zoo.showInfo();
        zoo.showAnimals();

        //obiekty klas Dog,Fish,Snake
        Dog dodge = new Dog("Max",2020, Dog.Breed.Chihuahua, Dog.Size.SMALL);

        Fish fish = new Fish("Wanda",
                2019,
                Fish.FoodValue.Poor,
                new ArrayList<Fish.Habitat>(
                        Arrays.asList(
                                Fish.Habitat.Lake,
                                Fish.Habitat.River)),
                4);
        Snake snake = new Snake("Joe",2000,160);

        //interfejs Speakable
        List<Speakable> speakableAnimals = new ArrayList();
        speakableAnimals.add(snake);
        speakableAnimals.add(fish);
        speakableAnimals.add(dodge);
        for(Speakable anim:speakableAnimals)
            anim.sound();


        //LAMBDY
        int []numbers = {-1,2,50,100};
        Lambda1 lambda1 = nums -> {
            int sum=0;
            for(int num:nums)
                sum+=num;
            return sum;
        };
        Lambda2 lambda2 = nums -> lambda1.add(nums)/nums.length;
        Lambda3 lambda3 = nums -> {
            System.out.println("Liczby większe od 2:");
            for(int num : nums)
                if(num>2)
                    System.out.println(num);
        };
        Lambda3 lambda3a = nums-> System.out.println(Arrays.stream(nums).filter(num->num>2).mapToObj(String::valueOf).collect(Collectors.joining(", ")));

        Numbers numbersObj = new Numbers(numbers);
        System.out.println("Suma liczba: "+numbersObj.add(lambda1));
        System.out.println("Średnia z liczb: "+numbersObj.avg(lambda2));
        numbersObj.show(lambda3);
        System.out.println("Alternatywny sposób implementacji ze strumieniami dla Lambda3");
        numbersObj.show(lambda3a);

        //zapis nazw zwierząt z Zoo do pliku
        convertAnimalsToTxt("animals.txt",zoo);
        convertAnimalsToTxt("badPathTest://animals.txt",zoo);
    }

    public static void convertAnimalsToTxt(String filePath,Zoo zoo){
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try{
            fos = new FileOutputStream(filePath,true);
            osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
            for(Animal animal : zoo.getAnimals())
                osw.write(animal.getName()+System.lineSeparator());

        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
            fnfe.printStackTrace();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(osw!=null)
                    osw.close();
                if(fos!=null)
                    fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }
}

