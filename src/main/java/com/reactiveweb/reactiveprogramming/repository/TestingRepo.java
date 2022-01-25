package com.reactiveweb.reactiveprogramming.repository;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface TestingRepo extends R2dbcRepository<TestingModel, Integer> {
}
