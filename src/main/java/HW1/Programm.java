package HW1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Programm {
    public static void main(String[] args) {
        int countPet = 20;
        Random rnd = new Random();
        int countHorsies = 0;
        int countCats = 0;
        int countDogs = 0;
        int indexPet = 0;


        List<BaseClassPet> Stado = new ArrayList<>();
        for (int i = 0; i<countPet; i++) {
            indexPet = rnd.nextInt(3);

            if (indexPet == 0) {
                Stado.add(new ClassCats());
                countCats++;
            } else if (indexPet == 1) {
                Stado.add(new ClassDogs());
                countDogs++;
            } else {
                Stado.add(new ClassHorsies());
                countHorsies++;
            }
            System.out.println(Stado.get(i).getInfo());
        }

        for (int i = 0; i<countPet; i++) {
            Stado.get(i).eat();
        }
        for (int i = 0; i<countPet; i++) {
            Stado.get(i).run(rnd.nextInt(1,1000));
        }
        }
    }


