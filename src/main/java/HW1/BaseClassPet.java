package HW1;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class BaseClassPet
{
    protected static Random rnd;
    protected static int countPet;
    protected String name;
    protected static String GolosText;
    protected int age;
    protected String color;
    protected int weight;

    static {
        BaseClassPet.countPet = 0;
        BaseClassPet.rnd = new Random();
    }
/**
 *
 * @param name Кличка животного
 * @param age Возраст животного
 * @param weight Вес животного
 *
 * */
    public BaseClassPet(String name, int age, int weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public BaseClassPet(){
        this(String.format("Pets number #%d",++BaseClassPet.countPet),BaseClassPet.rnd.nextInt(1,10),BaseClassPet.rnd.nextInt(0,30));
    }

    public void golos(BaseClassPet say){
        System.out.println(BaseClassPet.GolosText);
    }
    public void eat(){
        System.out.println("я скушал " + BaseClassPet.rnd.nextInt(1,5) + " единицы корма");
    }

    public void run(int countRun){
        System.out.println("Я прошел " + countRun + " шагов");
    }

    public String getInfo() {
        return String.format("Имя: %s  Возраст: %d  Вес: %s",
                this.name, this.age, this.weight);
    }

}
