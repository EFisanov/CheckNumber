import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputLine = "";
        Scanner scanner = new Scanner(System.in);

        while (!inputLine.equals("exit")) {

            System.out.print("Для выхода введите \"exit\". \n" +
                    "Введите целое положительное число, меньше 50: ");
            inputLine = scanner.nextLine();

            if (inputLine.equals("exit")) {
                System.out.print("Выход.");
                break;
            }

            try {
                int number = 0;

                try {
                    number = Integer.parseInt(inputLine);
                } catch (NumberFormatException exception) {
                    System.out.println("Число не целое или введена не допустимая команда");
                }

                if (number < 0) {
                    throw new NegativeNumberException("Число не положительное");
                }

                if (number >= 50) {
                    throw new InvalidArgumentException("Число больше 50");
                }

                BigDecimal fact = getFactorial(number);
                System.out.println(fact);
            } catch (NegativeNumberException | InvalidArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static BigDecimal getFactorial(int number) {
        BigDecimal result = BigDecimal.valueOf(1);
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}