//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить
// к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ScannerInputFloat sif = new ScannerInputFloat();
        System.out.println(sif.createNumberFloat());

// Задание 2

        int[] arr1 = null;
        int[] arr2 = {1, 2, 3, 45, 6};
        int[] arr3 = {77, 8, 4, 34, 25, 87, 99, 45, 46};
        DivisionByZero dbz = new DivisionByZero(arr3);
        dbz.division();
        DivisionByZero dbzNull = new DivisionByZero(arr1);
        dbzNull.division();
        DivisionByZero dbzIndexOut = new DivisionByZero(arr2);
        dbzIndexOut.division();

// Задание 3

        FixCode fx = new FixCode();
        fx.fix();
        fx.printSum(null, 234);


// задание 4
// Разработайте программу, которая выбросит Exception,
//// когда пользователь вводит пустую строку. Пользователю должно показаться сообщение,
//// что пустые строки вводить нельзя.
            try {
                String input = getEnteredString();
                System.out.println(input);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

    }


    public static String getEnteredString() throws RuntimeException {
        System.out.println("Введите строку: ");
        Scanner str = new Scanner(System.in);
        String string = str.nextLine();
        string = string.trim();
        if (string.isEmpty() || string == null) {
            throw new RuntimeException("Строка не может быть null или пустой!");
        }
        return string;


    }
}