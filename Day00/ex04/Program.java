import java.util.Arrays;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int[] intArray = new int[65_535];
        for (char c : input) {
            intArray[c]++;
        }
        char[] key = new char[10];
        int[] value = new int[10];
        for (int i = 0; i < 10; i++) {
            int max = 0;
            char c = 0;
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] > max) {
                    max = intArray[j];
                    c = (char)j;
                }
            }
                intArray[c] = 0;
                value[i] = max;
                key[i] = c;
        }
        double[] histogram = new double[10];
        for (int i = 0; i < 10; i++) {
            histogram[i] = (double)value[i] / (double)value[0] * 100;
        }
        char[][] print = new char[12][10];
        for (int i = 0; i < 10; i++) {
            print[0][i] = key[i];
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if (histogram[j] > 0.0) {
                    histogram[j] -= 11;
                    print[i][j] = '#';
                }
            }
        }
        for (int i = 11; i > -1; i--) {
            for (int j = 0; j < 10; j++) {
                if (print[i][j] == '\u0000' && i > 1) {
                    if (print[i - 1][j] == '#') {
                        if (j != 0 && value[j] < 10) {
                            System.out.print(" ");
                        }
                        System.out.print(value[j] + " ");
                    }
                } else if (print[i][j] != '\u0000') {
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(print[i][j] + " ");
                }
            }
            System.out.println();
            }
    }
}
