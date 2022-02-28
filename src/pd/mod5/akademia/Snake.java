package pd.mod5.akademia;

public class Snake extends Animal {
    public Snake(String name,int yearOfBirth,int length){
        super(name,yearOfBirth,Type.REPTILE);
        this.length = length;
    }
    @Override
    public void sound() {
        System.out.println("Metoda sound z Snake");
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;
}
