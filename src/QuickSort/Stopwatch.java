package QuickSort;

public class Stopwatch {
    public long startTime;

    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    public double stop() {
        var stopTime = System.currentTimeMillis();
        return Math.round((stopTime - startTime) * 100.0) / 100.0;

    }
}
