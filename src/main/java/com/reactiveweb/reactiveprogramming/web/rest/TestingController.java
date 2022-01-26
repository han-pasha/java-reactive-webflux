package com.reactiveweb.reactiveprogramming.web.rest;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import com.reactiveweb.reactiveprogramming.service.TestingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestingController {

    @Autowired
    private final TestingService testingService;

    @GetMapping("/welcome")
    Mono<String> welcome() {
        return Mono.just("welcome");
    }

    @PostMapping("/testing/create")
    Mono<TestingModel> create(@RequestBody TestingModel model) {
       return testingService.createTestingModel(model);
    }
}
