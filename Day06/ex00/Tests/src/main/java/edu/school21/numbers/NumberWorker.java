package edu.school21.numbers;

public class NumberWorker {
    public boolean isPrime(int number) {
        if (number < 2) throw new IllegalArgumentException();
        else if (number % 2 == 0) {
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

    public int digitsSum(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
