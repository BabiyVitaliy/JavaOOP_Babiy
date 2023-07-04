package HW1;

public class ClassHorsies extends BaseClassPet{
    private int MaxSpeed;

    public ClassHorsies(){
        super(String.format("Лошадка #%d",++ClassHorsies.countPet),
                ClassHorsies.rnd.nextInt(1,15),ClassHorsies.rnd.nextInt(20,200));
        this.MaxSpeed = ClassHorsies.rnd.nextInt(20,50);
    }
    public String getInfo()
    {
        return String.format("%s максимальная скорость: %d", super.getInfo(), this.MaxSpeed);
    }

}
