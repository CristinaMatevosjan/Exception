import java.util.Scanner;
import java.util.Locale;
public class ScannerInputFloat {
    public float createNumberFloat(){
        System.out.println("Введите число с плавающей точкой типа float:");
        Scanner sc=new Scanner(System.in).useLocale(Locale.US);

        while (!sc.hasNextFloat()) {
              sc.next();
            System.out.println("Допустимы только числа с плавающей точкой, попробуйте снова.");
        }
            float number=sc.nextFloat();
            sc.nextLine();
    return number;
}
}
