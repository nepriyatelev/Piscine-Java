import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int prime = 0;
        while (number != 42) {
            number = scanner.nextInt();
            if (isPrime(sumOfDigits(number))) {
                prime++;
            }
        }
        scanner.close();
        System.out.println("Count of coffee-request - " + prime);
    }

    public static int sumOfDigits(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else if (number % 2 == 0) {
            return number == 2;
        } else if (number % 3 == 0) {
            return number == 3;
        } else {
            for (int i = 5; i * i < number; i += 6) {
                if (number % i == 0 || number % (i + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
