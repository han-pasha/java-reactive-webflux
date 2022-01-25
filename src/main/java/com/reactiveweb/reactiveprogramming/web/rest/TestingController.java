package com.reactiveweb.reactiveprogramming.web.rest;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import com.reactiveweb.reactiveprogramming.service.TestingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestingController {

    @Autowired
    private final TestingService testingService;
    @Qualifier("getWebClientBuilder")
    @Autowired
    private WebClient.Builder client;

    @GetMapping("/welcome")
    Mono<String> welcome() {
        return Mono.just("welcome");
    }

    @PostMapping("/testing/create")
    Mono<TestingModel> create(@RequestBody TestingModel model) {
        return testingService.createTestingModel(model);
    }
}
