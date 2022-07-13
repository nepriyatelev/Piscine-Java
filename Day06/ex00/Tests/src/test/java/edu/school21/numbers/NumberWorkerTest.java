package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 18743})
    public void isPrimeForPrimes(int num) {
        assertTrue(numberWorker.isPrime(num));
    }
    @ParameterizedTest
    @ValueSource(ints = {15, 193345, 18123})
    public void  isPrimeForNotPrimes(int num) {
        assertFalse(numberWorker.isPrime(num));
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1})
    public void   isPrimeForIncorrectNumbers(int num) {
        assertThrows(IllegalArgumentException.class, () -> numberWorker.isPrime(num));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void   checkDigitsSum(int num, int sum) {
        assertEquals(sum, numberWorker.digitsSum(num));
    }
}