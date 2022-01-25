package com.reactiveweb.reactiveprogramming.dao;

import com.reactiveweb.reactiveprogramming.model.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1,10)
                .peek(i -> System.out.println("Processing Count: " + i))
                .mapToObj(i -> new Customer(i, "Customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing Count in stream: " + i))
                .map(i -> new Customer(i, "Customer" + i));
    }

    public Flux<Customer> getCustomersStreamWithoutDelay() {
        return Flux.range(1,10)
                .doOnNext(i -> System.out.println("Processing Count in stream: " + i))
                .map(i -> new Customer(i, "Customer" + i));
    }
//
//    public Mono<Customer> postCustomer() {
//        return Mono.just();
//    }
}
