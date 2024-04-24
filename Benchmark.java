public class Benchmark {
    public static void main(String[] args) {
        // benchmarking for event creation
        long startTime = System.nanoTime();
        // code for event creation
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("time taken for event creation: " + duration + " nanoseconds");

        // benchmarking for ticket booking
        startTime = System.nanoTime();
        // code for ticket booking
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("time taken for ticket booking: " + duration + " nanoseconds");

        // benchmarking for ticket cancellation
        startTime = System.nanoTime();
        // code for ticket cancellation
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("time taken for ticket cancellation: " + duration + " nanoseconds");

        // benchmarking for memory usage
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        // code for memory-intensive operation
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        System.out.println("memory used: " + memoryUsed + " bytes");
    }
}