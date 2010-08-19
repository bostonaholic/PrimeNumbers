package com.chops.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    public List<Integer> generate(int startingValue, int endingValue) {
        List<Integer> primes = new ArrayList<Integer>();

        if (endingValue < startingValue) {
            // swap the startingValue and endingValue if endingValue is less than startingValue
            int tmp = startingValue;
            startingValue = endingValue;
            endingValue = tmp;
        }

        // we know there are no primes less than 2
        startingValue = Math.max(startingValue, 2);

        for (int i = startingValue; i <= endingValue; i++) {
            if (isPrime(i)) {
                primes.add(new Integer(i));
            }
        }

        return primes;
    }

    public boolean isPrime(int value) {
        boolean isPrime = true;

        if (value < 2) {
            // take care of negatives, 0, and 1
            isPrime = false;
        } else if (value == 2) {
            // special case, 2 is prime
            isPrime = true;
        } else if (value % 2 == 0) {
            // we can knock out half of the loop iterations by eliminating the evens
            isPrime = false;
        } else {
            for (int i = 3; i*i <= value; i=i+2) {
                // only run the loop for i up to the square root of the given value
                // the loop is optimized to only hit odd numbers. if a number is
                // divisable by an even, it would have been caught above during mod 2
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }
}
