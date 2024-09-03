import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число:");
        int number = scanner.nextInt();

        if (number < 0) {
            throw new RuntimeException("Число не положительное");
        }
        if (number >= 50) {
            throw new RuntimeException("Число больше 50");
        }

        BigDecimal fact = getFactorial(number);
        System.out.println(fact);
    }

    public static BigDecimal getFactorial(int number) {
        BigDecimal result = BigDecimal.valueOf(1);
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}