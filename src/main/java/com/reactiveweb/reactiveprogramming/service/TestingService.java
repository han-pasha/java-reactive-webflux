package com.reactiveweb.reactiveprogramming.service;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import reactor.core.publisher.Mono;

public interface TestingService {
    Mono<TestingModel> createTestingModel(TestingModel model);
}
