package com.reactiveweb.reactiveprogramming.service.impl;

import com.google.common.base.Preconditions;
import com.reactiveweb.reactiveprogramming.model.TestingModel;
import com.reactiveweb.reactiveprogramming.repository.TestingRepo;
import com.reactiveweb.reactiveprogramming.service.TestingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TestingServiceImpl implements TestingService {

    /**
     * THIS REPO COULDN'T BE AUTO WIRED BECAUSE
     * R2DBC DOESN'T ALLOW BEAN ON ITS REPO
     */
    @Autowired
    private TestingRepo testingRepo;

    @Override
    public Mono<TestingModel> createTestingModel(TestingModel model) {
        Optional<Mono<TestingModel>>  test = Optional.of(Mono.just(model));
//        Preconditions.checkArgument()
        Preconditions.checkNotNull(test);
        return Mono.just(model)
                .flatMap(x -> testingRepo.save(x))
                .doOnSuccess(x -> System.out.println("Welp"))
                .switchIfEmpty(Mono.empty());
    }
}
