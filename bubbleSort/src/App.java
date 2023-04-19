/*Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл. */

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void bubbleSort(Integer[] array1) { //Сортировка пузырьком с заисью в файл шагов сортировки
        int count = 1;
        for (int i = 0; i < array1.length - 1; i++) {
            try (FileWriter writer = new FileWriter("log.txt", true)) { //Готовим файл для записи
                for (int j = 0; j < array1.length - i - 1; j++) {
                    if (array1[j + 1] < array1[j]) {
                        int swap = array1[j];
                        array1[j] = array1[j + 1];
                        array1[j + 1] = swap;
                        writer.append("Step" + count + '\n');       //Формируем файл лога
                        for (int c = 0; c < array1.length; c++) {
                            writer.append(array1[c].toString() + " ");
                            writer.flush();
                        }
                        writer.append('\n');
                        count++;
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {    
        Scanner in = new Scanner(System.in);                        //Приглашение ко вводу
        System.out.print("Введите размер массива для сортировки: ");
        int size = in.nextInt();                                    // Читаем с клавиатуры размер массива и записываем в size
        Integer array1[] = new Integer[size];                       // Создаём массив int размером в size
        System.out.println("Введите массив через пробел:");
        for (int i = 0; i < size; i++) {
            array1[i] = in.nextInt();                               // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.println("Ваш введенный массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(array1[i] + " ");                      // Выводим на экран, полученный массив
        }
        System.out.println();
        in.close();
        bubbleSort(array1);                                         //Вызов метода сортировки
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
    }
}
