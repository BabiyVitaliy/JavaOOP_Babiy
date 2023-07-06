package HW2;

public class Homework {


    /**
     * Задание
     * <p>
     * Предположим, вы разрабатываете какую-то компьютерную игру, в которой есть несколько типов объектов (классов):
     * 1. Здание (имеет текущий уровень здоровья)
     * 2. Герой (имеет текущий уровень здоровья и текущий уровень магической энергии)
     * 3. Нейтральный персонаж (имеет текущий уровень здоровья)
     * <p>
     * Также у вас есть класс Render с методом showIndicator, который срабатывает при наведении мышки на объект
     * и работает следующим образом:
     * 1. Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
     * 2. Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
     * * В качестве упрощения, пусть вывод на дисплей это запись информации в консоль.
     * * То есть вы пишете код, который выводит на консоль информацию.
     * <p>
     * <p>
     * Подсказка: нужно ввести 2 интерфейса: наличие здоровья и наличие магической энергии.
     * В классе Render проверять только на эти интерфейсы и выводить нужную информацию.
     * Необходимо продумать, какие методы должны быть в интерфейсе.
     * <p>
     * ЧТО ДЕЛАТЬ НЕ НУЖНО:
     * Нельзя завязываться на конкретные классы. Предполагается, что таких классов очень много и они постоянно добавляются.
     * <p>
     * * Необязательные задания, которые не относятся к теме, но при сильном желании можно реализовать.
     * * Со звездочкой: реализовать в консоли отображение индикатора.
     * Например, при максимальном уровне здоровья 100 и текущем 40 можно отобразить вот такую ленточку: [xxxx      ]
     * ** С двумя звездочками: раскрасить вывод. Чем меньше здоровья, тем "краснее" цвет индикатора. Для полного здоровья - цвет зеленый.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";


    public static void main(String[] args) {
    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим
         * уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с
         * текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            // Не должно быть упоминания конкретных классов!!!
            if (object instanceof HasHealth) {
                int maxHealth = ((HasHealth) object).getMaxHealth();
                int currentHealth = ((HasHealth) object).getCurrentHealth();

                System.out.println(String.format("Текущий уровень здоровья: %d, максимальный уровень здоровья: %d",
                        currentHealth, maxHealth));
                printHealthIndicator(maxHealth, currentHealth);

            }
            if (object instanceof HasMana) {
                int maxMana = ((HasMana) object).getMaxMana();
                int currentMana = ((HasMana) object).getCurrentMana();

                System.out.println(String.format("Текущий уровень маны: %d, максимальный уровень маны: %d",
                        currentMana, maxMana));
                printManaIndicator(maxMana, currentMana);
            }
        }

        public void printHealthIndicator(int max, int current) {
            String color;
            int fillBackground = current * 10 / max;
            if (fillBackground >= 7) {
                color = ANSI_GREEN_BACKGROUND;
            } else if (fillBackground > 2) {
                color = ANSI_YELLOW_BACKGROUND;
            } else {
                color = ANSI_RED_BACKGROUND;
            }
            printIndicator(fillBackground, color);
        }

        public void printManaIndicator(int max, int current) {
            String color;
            int fillBackground = current * 10 / max;
            color = ANSI_BLUE_BACKGROUND;
            printIndicator(fillBackground, color);
        }

        public void printIndicator(int fillBackground, String color) {
            System.out.print("[");
            System.out.print(color);
            for (int i = 1; i < 10; i++) {
                if (fillBackground > 0) {
                    System.out.print("-");
                    fillBackground--;
                } else {
                    System.out.print(ANSI_RESET + " ");
                }
            }
            System.out.println(ANSI_RESET + "]");
        }
    }
    static class Building implements HasHealth {

        private int maxHealthPoint;
        private int currentHealthPoint;

        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
        // FIXME: 29.06.2023 Дописать нужное
        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }
    }

    static class Hero implements HasHealth, HasMana {

        private int maxHealthPoint;
        private int currentHealthPoint;

        private int maxManaPoint;
        private int currentManaPoint;

        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }
        // FIXME: 29.06.2023 Дописать нужное

        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }

        @Override
        public int getMaxMana() {
            return maxManaPoint;
        }

        @Override
        public int getCurrentMana() {
            return currentManaPoint;
        }
    }

    static class Neutral implements HasHealth {

        private int maxHealthPoint;
        private int currentHealthPoint;

        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
        // FIXME: 29.06.2023 Дописать нужное
        @Override
        public int getMaxHealth() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealth() {
            return currentHealthPoint;
        }
    }

    public interface HasHealth {
        int getMaxHealth();

        int getCurrentHealth();
    }

    public interface HasMana {
        int getMaxMana();

        int getCurrentMana();
    }
}


