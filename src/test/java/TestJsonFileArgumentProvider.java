import java.math.BigDecimal;

import org.fingerprintsoft.junit.enabled.EnabledIfReachable;
import org.fingerprintsoft.junit.json.JsonFileSource;
import org.fingerprintsoft.junit.json.JsonSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class TestJsonFileArgumentProvider {


    @JsonFileSource(resources = {"test.json"})
    @ParameterizedTest
    void test(BigDecimal actual, BigDecimal expected) {
        Assertions.assertEquals(expected, actual);
    }

    @JsonFileSource(resources = {"test-one-arg.json"})
    @ParameterizedTest
    void test(BigDecimal actual) {
        Assertions.assertNotNull(actual);
    }

    @JsonSource(
            value = "[" +
                    "{" +
                    "    'type': java.math.BigDecimal, " +
                    "    'value': '1'" +
                    "}," +
                    "{" +
                    "    'type': java.math.BigDecimal, " +
                    "    'value': '1'" +
                    "}" +
                    "]"
    )
    @ParameterizedTest
    void test2(BigDecimal actual, BigDecimal expected) {
        Assertions.assertEquals(expected, actual);
    }

    @JsonSource(
            value = "{" +
                    "    'type': java.math.BigDecimal, " +
                    "    'value': '1'" +
                    "}"
    )
    @ParameterizedTest
    void test2(BigDecimal actual) {
        Assertions.assertNotNull(actual);
    }

    @Test
    @EnabledIfReachable(
            url = "http://google.com/",
            timeoutMillis = 1000)
    void reachableUrl() { }

    @Test
    @EnabledIfReachable(
            url = "http://com.google/",
            timeoutMillis = 1000)
    void unreachableUrl() { }
}
