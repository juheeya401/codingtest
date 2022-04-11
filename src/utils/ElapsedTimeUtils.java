package utils;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class ElapsedTimeUtils {

    private static Instant start;
    private static Instant finish;

    public static void start() {
        start = Instant.now();
    }

    public static void finish() {
        Objects.nonNull(start);
        finish = Instant.now();
        printTime();
        resetTime();
    }

    private static void printTime() {
        Objects.nonNull(start);
        Objects.nonNull(finish);

        NumberFormat format = NumberFormat.getInstance();

        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println(">>>> elapsedTime(ms) = " + format.format(elapsedTime) + " ms");
        //System.out.println(">>>> elapsedTime(ms) = " + elapsedTime + " ms");
    }

    private static void resetTime() {
        start = null;
        finish = null;
    }
}
