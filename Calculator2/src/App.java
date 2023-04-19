/*дополнительно. К калькулятору из предыдущего дз добавить логирование.
1 + 3 = 4
4 + 3 = 7 */

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception { //Приглашение ко вводу и т.д.
        Scanner in = new Scanner(System.in); 
        System.out.print("Введите число 1: ");
        Double num1 = in.nextDouble();
        System.out.print("Введите операцию (+,-,*,/): ");
        char oper = in.next().charAt(0);
        System.out.print("Введите число 2: ");
        Double num2 = in.nextDouble();
        if (oper == '/' && num2 == 0) {
            System.out.printf("Делить на 0 НЕЛЬЗЯ!");
            System.exit(1);
        }
        double result;

        try (FileWriter writer = new FileWriter("log.txt", true)) { //Готовим файл лога
            switch (oper) {
                case '+':
                    result = num1 + num2;
                    System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                    writer.append(num1 + " + " + num2 + " = " + result);            //Дописываем файл лога
                    writer.flush();
                    writer.append('\n');
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                    writer.append(num1 + " - " + num2 + " = " + result);
                    writer.flush();
                    writer.append('\n');
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                    writer.append(num1 + " * " + num2 + " = " + result);
                    writer.flush();
                    writer.append('\n');
                    break;
                case '/':
                    result = num1 / num2;
                    System.out.printf("Результат введенной операции равен %.2f %n \n", result);
                    writer.append(num1 + " / " + num2 + " = " + result);
                    writer.flush();
                    writer.append('\n');
                    break;
                default:
                    System.out.printf("Такой операции нет в калькуляторе, перезапустите прорамму и введите всё заново");
                    break;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        in.close();

    }
}
