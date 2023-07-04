package HW1;

public class ClassCats extends BaseClassPet{
    private int TailLength;

    public ClassCats(){
        super(String.format("Котик #%d",++ClassCats.countPet),
                ClassCats.rnd.nextInt(0,5),ClassCats.rnd.nextInt(1,15));
        this.TailLength = ClassCats.rnd.nextInt(0,10);
    }
    public String getInfo()
    {
        return String.format("%s длина хвоста: %d", super.getInfo(), this.TailLength);
    }

}
