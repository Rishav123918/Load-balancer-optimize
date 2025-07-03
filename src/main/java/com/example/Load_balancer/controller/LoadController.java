package com.example.Load_balancer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@RestController
public class LoadController {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    @GetMapping("/process")
    public String handleRequest() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        Callable<String> task = () -> {
            Thread.sleep(1000); // simulate load
            return "Thread: " + Thread.currentThread().getName();
        };

        Future<String> result = executor.submit(task);
        String threadInfo = result.get();

        long endTime = System.currentTimeMillis();
        return threadInfo +
                " | Time taken: " + (endTime - startTime) + "ms" +
                " | Timestamp: " + LocalDateTime.now();
    }
}

//output for single server : Thread: pool-2-thread-1 | Time taken: 1025ms | Timestamp: 2025-07-03T18:53:15.763989600
