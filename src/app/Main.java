package app;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] array = new int[] {2, -86, -7, 74, 51, 6, 87, 33, -42, 13, 24, -27, -6, 3, 67, -30, -58, 17, 48, 0};

        // Для тесту - всі значення позитивні
//        int [] array = new int[] {2, 5, 7, 74, 51, 6, 87, 33, 42, 13, 24, 27, 6, 3, 67, 30, 58, 17, 48, 0};

        int sumOfNegative = 0;
        int countEven = 0;
        int countOdd = 0;

        int maxValue = 0;
        int maxIndex = 0;

        int minValue = 0;
        int minIndex = 0;

        int firstNegativeIndex = -1;
        int sumAfterFirstNegative = 0;
        int countAfterFirstNegative = 0;

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            // Сума всіх від'ємних чисел масиву
            if (element < 0) {
                sumOfNegative += element;
            }

            // Кількість парних і непарних чисел визначаємо шляхом розрахунку остачі від ділення на 2
            if (element % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }

            // Найбільший елемент масиву і його індекс
            if (element >= maxValue) {
                maxValue = element;
                maxIndex = i;
            }

            // Найменший елемент масиву і його індекс
            if (element <= minValue) {
                minValue = element;
                minIndex = i;
            }

            // Розрахунок середнього арифметичного після 1-го від'ємного числа в масиві
            // Знаходим індекс перхого від'ємного елемента
            if (element < 0 && firstNegativeIndex == -1) {
                firstNegativeIndex = i;
            }

            // Сума чисел після першого від'ємного елементу
            if (firstNegativeIndex != -1 && i > firstNegativeIndex) {
                sumAfterFirstNegative += element;
                countAfterFirstNegative++;
            }
        }

        double average = (double) sumAfterFirstNegative / countAfterFirstNegative;

        System.out.println("Елементи масиву: " + Arrays.toString(array));
        System.out.println("Сума від'ємних чисел: " + sumOfNegative);
        System.out.println("Кількість парних чисел: " + countEven);
        System.out.println("Кількість непарних чисел: " + countOdd);
        System.out.printf("Найменший елемент: %d (з індексом %d)\n", minValue, minIndex);
        System.out.printf("Найбільший елемент: %d (з індексом %d)\n", maxValue, maxIndex);

        if (firstNegativeIndex == -1) {
            System.out.println("Масив не міститься від'ємних чисел");
        } else {
            System.out.printf("Середнє арифметичне чисел після першого від'ємного числа: %.2f", average);
        }

        // Можна окремим методом але потрібно пройти більше циклів
//        double v = averageAfterFirstNegative(array);

    }

    static double averageAfterFirstNegative(int[] array) {
        int firstNegativeIndex = 0;
        int sumAfterFirstNegative = 0;
        int countAfterFirstNegative = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                firstNegativeIndex = i;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i > firstNegativeIndex) {
                sumAfterFirstNegative += array[i];
                countAfterFirstNegative++;
            }
        }

        return  (double) sumAfterFirstNegative / countAfterFirstNegative;
    }

}
