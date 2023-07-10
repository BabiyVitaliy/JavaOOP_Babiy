package HW3;
/**
 * Создать класс Контейнер - Container.!
 * В контейнере могут быть ящики (класс Box).!
 * <p>
 * У каждого ящика есть вес.!z
 * У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков,
 * которые находятся в контейнере.
 * <p>
 * 1. Класс Контейнер должен быть Comparable. Сравнивать он должен по весам
 * контейнера (чем меньше вес, тем меньше контейнер).
 * 2. Класс ContainerCountComparator - Comparator, который сравнивает контейнеры
 * по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
 * 3. Класс контейнер должен быть Iterable - итерирование должно происходить по
 * ящикам внутри контейнера.
 * <code>
 * Container c = new Container(...);
 * // ...
 * for (Box box: c) {
 * box - это контейнер
 * }
 * </code>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Java_OOP_Java_BabiyVV {

    public static void main(String[] args) {

        Container container1 = new Container();
        container1.addBox(new Box());
        container1.addBox(new Box());
        container1.addBox(new Box());
        container1.addBox(new Box());
        container1.addBox(new Box());
        container1.addBox(new Box());
        container1.addBox(new Box());

        Container container2 = new Container();
        container2.addBox(new Box());
        container2.addBox(new Box());
        container2.addBox(new Box());
        container2.addBox(new Box());
        container2.addBox(new Box());


        Container container3 = new Container();
        container3.addBox(new Box());
        container3.addBox(new Box());
        container3.addBox(new Box());
        container3.addBox(new Box());

        System.out.println(container1.size() + " ящ. " + container1.getClass().getSimpleName() + " общим весом: " +
                container1.getWeigth() + " кг. " + container1);
        System.out.println(container2.size() + " ящ. " + container2.getClass().getSimpleName() + " общим весом: " +
                container2.getWeigth() + " кг. " + container2);
        System.out.println(container3.size() + " ящ. " + container3.getClass().getSimpleName() + " общим весом: " +
                container3.getWeigth() + " кг. " + container3);

        Set<Integer> containersCount = new TreeSet<>(new ContainerCountComparator());
        containersCount.addAll(Arrays.asList(container1.size(), container2.size(), container3.size()));

        System.out.println("по количеству ящиков: "+ containersCount);

        Set<Integer> containersWights = new TreeSet<>(Arrays.asList(container1.getWeigth(), container2.getWeigth(), container3.getWeigth()));

        System.out.println("по весу: " + containersWights);





    }

    static class Container implements Iterable<Integer>, Comparable<Container> {
        private List<Integer> boxies = new ArrayList<>();
        int weight = this.getWeigth();

        public void addBox(Box box) {
            boxies.add(box.getWeigth());
        }

        @Override
        public Iterator<Integer> iterator() {
            return boxies.iterator();
        }

        public int size() {
            return boxies.size();
        }

        @Override
        public int compareTo(Container another) {
            return weight - another.getWeigth();
        }

        public int getWeigth() {
            int weigthContainer = 0;
            for (int n : boxies) {
                weigthContainer += n;
            }
            return weigthContainer;
        }

        @Override
        public String toString() {
            return "" + boxies + "";
        }



    }

    static class Box {
        int weight = ThreadLocalRandom.current().nextInt(10, 21);

        @Override
        public String toString() {
            return "[" + weight + "]";
        }

        public int getWeigth() {
            return this.weight;
        }
    }

    static class ContainerCountComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}
