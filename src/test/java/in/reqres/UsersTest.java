package in.reqres;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:in/reqres")
                .parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    @Test
    void testParallelByTags() {
        Results results = Runner.path("classpath:in/reqres")
                .tags("@smoke")
                .parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}
