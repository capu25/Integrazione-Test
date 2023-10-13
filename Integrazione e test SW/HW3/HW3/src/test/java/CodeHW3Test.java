import net.jqwik.api.*;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.example.CodeHW3;
import org.junit.jupiter.api.Assertions;

public class CodeHW3Test {
    CodeHW3 test = new CodeHW3();

    @Provide
    IntegerArbitrary validInteger() {
        return Arbitraries.integers().between(-100, 100);
    }
    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void evenOrOddTest(@ForAll("validInteger") int value) {
        boolean result = test.evenOrOdd(value);
        boolean evenOrOdd = evenOrOddCheck(value);

        Assertions.assertEquals(evenOrOdd, result);
        Statistics.label("ExpectedResult").collect(evenOrOdd);
        Statistics.label("OurMethod").collect(result);
    }

    @Property
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void isPrimeTest(@ForAll("validInteger") int value) {
        boolean result = test.isPrime(value);
        boolean isPrime = isPrimeCheck(value);

        Assertions.assertEquals(isPrime, result);
        Statistics.label("ExpectedResult").collect(isPrime);
        Statistics.label("OurMethod").collect(result);
    }

    private static boolean evenOrOddCheck(int value){
        if(value % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
    private boolean isPrimeCheck(int value) {
        if (value <= 1) {
            return false;
        }
        if (value <= 3) {
            return true;
        }
        if (value % 2 == 0 || value % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= value; i += 6) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
