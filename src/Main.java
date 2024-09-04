import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.print("Для выхода введите \"exit\". \n" +
                    "Введите целое положительное число, до 50: ");

            String inputLine = bufferedReader.readLine();

            try {
                if (inputLine.matches("[a-zA-Z]+") && inputLine.equals("exit")) {
                    System.out.print("Выход.");
                    System.exit(0);
                }

                if (inputLine.charAt(0) == '-') {
                    throw new NegativeNumberException("Число не положительное");
                }

                if (inputLine.contains(".")) {
                    throw new NotIntegerException("Число не целое");
                }

                if (inputLine.matches("[0-9]+")) {
                    int number = Integer.parseInt(inputLine);
                    if (number >= 50) {
                        throw new InvalidArgumentException("Число больше 49");
                    }
                    BigDecimal fact = getFactorial(number);
                    System.out.println(fact);
                } else {
                    throw new NotSupportedException("Команда не поддерживается");
                }


            } catch (NotIntegerException | NotSupportedException | NegativeNumberException |
                     InvalidArgumentException exception) {
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