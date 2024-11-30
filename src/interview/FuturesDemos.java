package interview;

import java.util.concurrent.CompletableFuture;

public class FuturesDemos {

    public static void main(String[] args) {
        print("Starting...");

        //CompletableFuture data = supplyAsync({...})
        CompletableFuture<String> fetchData = CompletableFuture.supplyAsync(() -> {
            print("Fetching data...");
            simulateDelay(3000);
            print("Received data.");
            return "the data";
        });

        //Callback:
        //CompletableFuture finalData = data.thenApply(d -> {...});
        CompletableFuture<String> finalData = fetchData.thenApply(data -> {
            print("Processing data...");
            simulateDelay(3000);
            String processedData = data.toUpperCase();
            print("Processing complete.");
            return processedData;
        });

        //Callback:
        //finalData.thenAccept(result -> {...});
        finalData.thenAccept(result -> {
            print("Result: " + result);
        });

        //block until finalData future completes...
        finalData.join();

        print("End.");
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void simulateDelay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
