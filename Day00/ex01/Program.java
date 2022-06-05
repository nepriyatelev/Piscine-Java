import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        int iteration = 1;
        boolean isSimple = true;
        if (number < 2) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isSimple = false;
                break;
            }
            iteration++;
        }
        System.out.println(isSimple + " " + iteration);
    }
}
