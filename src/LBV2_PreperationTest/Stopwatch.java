package LBV2_PreperationTest;

public class Stopwatch {
    public long startTime;

    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    public double stop() {
        var stopTime = System.currentTimeMillis();
        return stopTime - startTime;

    }
}
