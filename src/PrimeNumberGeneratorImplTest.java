import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimeNumberGeneratorImplTest {
    PrimeNumberGenerator png = null;
    List<Integer> list = null;
    
    List<Integer> firstTwentySixPrimes = new ArrayList<Integer>(26);

    @Before
    public void setUp() throws Exception {
        png = new PrimeNumberGeneratorImpl();
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void negativeIsNotPrime() {
        assertFalse(png.isPrime(-14));
    }

    @Test
    public void zeroIsNotPrime() {
        assertFalse(png.isPrime(0));
    }

    @Test
    public void oneIsNotPrime() {
        assertFalse(png.isPrime(1));
    }

    @Test
    public void twoIsPrime() {
        assertTrue(png.isPrime(2));
    }

    @Test
    public void sixIsNotPrime() {
        assertFalse(png.isPrime(6));
    }

    @Test
    public void highIsPrime() {
        assertTrue(png.isPrime(7907));
    }

    @Test
    public void maxIntIsNotPrime() {
        assertFalse(png.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void firstTwentySixPrimes() {
    	buildFirsttwentySix();
        list = png.generate(0, 102);
        assertTrue(list.size() == 26);
        // must be a subset of each
        assertTrue(list.containsAll(firstTwentySixPrimes));
        assertTrue(firstTwentySixPrimes.containsAll(list));
    }

    @Test
    public void toTenForwards() {
        list = png.generate(0, 10);
        for (Integer value : list ) {
            assertTrue(png.isPrime(value));
        }
    }

    @Test
    public void toTenBackwards() {
        list = png.generate(10, 0);
        for (Integer value : list ) {
            assertTrue(png.isPrime(value));
        }
    }

    @Test
    public void largeGenerate() {
        list = png.generate(0, 7920);
        for (Integer value : list ) {
            assertTrue(png.isPrime(value));
        }
    }

    @Test
    public void veryLargeGenerate() {
        list = png.generate(Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Integer value : list ) {
            assertTrue(png.isPrime(value));
        }
    }

    @Test
    public void zeroToZeroGenerate() {
        list = png.generate(0, 0);
        assertTrue(list.size() == 0);
    }

    @Test
    public void negativeToPositiveGenerate() {
        list = png.generate(-14, 27);
        for (Integer value : list ) {
            assertTrue(png.isPrime(value));
        }
    }
    
    private void buildFirsttwentySix() {
    	firstTwentySixPrimes.add(2);
    	firstTwentySixPrimes.add(3);
    	firstTwentySixPrimes.add(5);
    	firstTwentySixPrimes.add(7);
    	firstTwentySixPrimes.add(11);
    	firstTwentySixPrimes.add(13);
    	firstTwentySixPrimes.add(17);
    	firstTwentySixPrimes.add(19);
    	firstTwentySixPrimes.add(23);
    	firstTwentySixPrimes.add(29);
    	firstTwentySixPrimes.add(31);
    	firstTwentySixPrimes.add(37);
    	firstTwentySixPrimes.add(41);
    	firstTwentySixPrimes.add(43);
    	firstTwentySixPrimes.add(47);
    	firstTwentySixPrimes.add(53);
    	firstTwentySixPrimes.add(59);
    	firstTwentySixPrimes.add(61);
    	firstTwentySixPrimes.add(67);
    	firstTwentySixPrimes.add(71);
    	firstTwentySixPrimes.add(73);
    	firstTwentySixPrimes.add(79);
    	firstTwentySixPrimes.add(83);
    	firstTwentySixPrimes.add(89);
    	firstTwentySixPrimes.add(97);
    	firstTwentySixPrimes.add(101);
    }
}
