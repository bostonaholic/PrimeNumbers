package com.chops.primenumbers;

import java.util.List;

public class PrimeNumberMain {
    public static void usage() {
        System.out.println("usage:");
        System.out.println("PrimeNumberMain <startingValue:int> <endingValue:int>");
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            usage();
        } else {
            int startingValue = 0;
            int endingValue = 0;
            
            try {
                startingValue = Integer.parseInt(args[0]);
                endingValue = Integer.parseInt(args[1]);
                
                PrimeNumberGenerator g = new PrimeNumberGeneratorImpl();
                List<Integer> primes = g.generate(startingValue, endingValue);

                System.out.println("Primes:");
                System.out.println(primes.toString());
            }
            catch (NumberFormatException nfe) {
                usage();
            }
        }
    }
}
