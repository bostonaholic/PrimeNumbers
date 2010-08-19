import org.junit.Test;

public class PrimeNumberMainTest {
    String[] args = null;

    @Test
    public void testUsage() {
        PrimeNumberMain.usage();
    }

    @Test
    public void testMainNoArgs() {
        args = new String[0];
        PrimeNumberMain.main(args);
    }

    @Test
    public void testMainOneArg() {
        args = new String[1];
        PrimeNumberMain.main(args);
    }

    @Test
    public void testMainWithTextArgs() {
        args = new String[2];
        args[0] = "5";
        args[1] = "text";
        PrimeNumberMain.main(args);
    }

    @Test
    public void testMain() {
        args = new String[2];
        args[0] = "0";
        args[1] = "102";
        PrimeNumberMain.main(args);
    }
}