package com.reactiveweb.reactiveprogramming.handler;

import com.reactiveweb.reactiveprogramming.dao.CustomerDao;
import com.reactiveweb.reactiveprogramming.dao.TestingDao;
import com.reactiveweb.reactiveprogramming.model.Customer;
import com.reactiveweb.reactiveprogramming.model.TestingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private TestingDao testingDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest request) {
        Flux<Customer> customerList = customerDao.getCustomersStreamWithoutDelay();
        return ServerResponse.ok().body(customerList, Customer.class);
    }

    public Mono<ServerResponse> inputCustomer(ServerRequest request) {
        int customerId = Integer.parseInt(request.pathVariable("input"));
//        customerDao.getCustomersStreamWithoutDelay().filter(f -> f.getId() == customerId).take(1).single();
        Mono<Customer> returnCustomer = customerDao.getCustomersStreamWithoutDelay().filter(f -> f.getId() == customerId).next();
        return ServerResponse.ok().body(returnCustomer, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request) {
        Mono<Customer> saveCustomer = request.bodyToMono(Customer.class);
        return ServerResponse.ok().body(saveCustomer, Customer.class);
    }

    public Mono<ServerResponse> saveTesting(ServerRequest request) {
        Mono<TestingModel> saveCustomer = request.bodyToMono(TestingModel.class);
        Mono<TestingModel> test = saveCustomer.flatMap(tiket -> testingDao.postTesting(tiket));
        return ServerResponse.ok().body(test, TestingModel.class);
    }
}
