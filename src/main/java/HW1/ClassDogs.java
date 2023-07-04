package HW1;

public class ClassDogs extends BaseClassPet{
    private int JawStrenght;

    public ClassDogs(){
        super(String.format("Собачка #%d",++ClassDogs.countPet), ClassDogs.rnd.nextInt(1,10),ClassDogs.rnd.nextInt(0,30));
        this.JawStrenght = ClassDogs.rnd.nextInt(0,10);
    }
    public String getInfo()
    {
        return String.format("%s сила укуса: %d", super.getInfo(), this.JawStrenght);
    }


}
