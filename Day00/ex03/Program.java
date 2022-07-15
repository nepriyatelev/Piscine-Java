import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String week = scanner.nextLine();
        long arrGrade = 0;
        int numberWeek = 0;
        while (!(week.equals("42"))) {
            numberWeek++;
            if (week.equals("Week " + numberWeek) && numberWeek < 19) {
                arrGrade += minGrade(scanner);
                arrGrade *= 10;
            } else {
                System.err.println("Illegal Argument");
                scanner.close();
                System.exit(-1);
            }
            week = scanner.nextLine();
        }
        printStatistic(arrGrade, numberWeek);
        scanner.close();
    }

    public static long minGrade(Scanner scanner) {
        int min = 9;
        for (int i = 0; i < 5; i++) {
            int inputNumber = scanner.nextInt();
            if (inputNumber < 1 || inputNumber > 9) {
                System.err.println("Illegal Argument");
                scanner.close();
                System.exit(-1);
            }
            if (inputNumber < min) {
                min = inputNumber;
            }
        }
        scanner.nextLine();
        return min;
    }

    public static void printStatistic(long arrGrade, int numberWeek) {
        long tmpArrGrade = 0;
        while (arrGrade != 0) {
            tmpArrGrade += arrGrade % 10;
            arrGrade /= 10;
            if (arrGrade != 0) {
                tmpArrGrade *= 10;
            }
        }
        for (int i = 1; i < numberWeek + 1; i++) {
            System.out.print("Week ");
            System.out.print(i);
            if (i < 10) {
                System.out.print("  ");
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < tmpArrGrade % 10; j++) {
                System.out.print("=");
            }
            System.out.println(">");
            tmpArrGrade /= 10;
        }
    }
}