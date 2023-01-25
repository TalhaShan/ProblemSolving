package Concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Basics {

    //Using CompletableFuture as a Simple Future
//        First, the CompletableFuture class implements the Future interface so that we can use it as a Future implementation but with additional completion logic.
//        For example, we can create an instance of this class with a no-arg constructor to represent some future result, hand it out to the consumers, and complete it at some time in the future using the complete method. The consumers may use the get method to block the current thread until this result is provided.
//         In the example below, we have a method that creates a CompletableFuture instance, then spins off some computation in another thread and returns the Future immediately.
//        When the computation is done, the method completes the Future by providing the result to the complete method:


    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    //2. //CompletableFuture with Encapsulated Computation Logic


//
//    CompletableFuture<String> completableFuture
//            = CompletableFuture.supplyAsync(() -> "Hello");
//
//    CompletableFuture<String> future = completableFuture
//            .thenApply(s -> s + " World");
//
//    assertEquals("Hello World", future.get());
//    Copy
//    If we don't need to return a value down the Future chain, we can use an instance of the Consumer functional interface. Its single method takes a parameter and returns void.
//
//    There's a method for this use case in the CompletableFuture. The thenAccept method receives a Consumer and passes it the result of the computation. Then the final future.get() call returns an instance of the Void type:
//
//    CompletableFuture<String> completableFuture
//            = CompletableFuture.supplyAsync(() -> "Hello");
//
//    CompletableFuture<Void> future = completableFuture
//            .thenAccept(s -> System.out.println("Computation returned: " + s));
//
//future.get();
//    Copy
//    Finally, if we neither need the value of the computation nor want to return some value at the end of the chain, then we can pass a Runnable lambda to the thenRun method. In the following example, we simply print a line in the console after calling the future.get():
//
//    CompletableFuture<String> completableFuture
//            = CompletableFuture.supplyAsync(() -> "Hello");
//
//    CompletableFuture<Void> future = completableFuture
//            .thenRun(() -> System.out.println("Computation finished."));
//
//future.get();

    public static void main(String[] args) {
        try {
            calculateAsync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }




}

