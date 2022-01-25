package com.reactiveweb.reactiveprogramming.dao;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import com.reactiveweb.reactiveprogramming.repository.TestingRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class TestingDao {

    @Autowired
    private TestingRepo testingRepo;
    public Mono<TestingModel> postTesting(TestingModel testingModel) {
        return testingRepo.save(testingModel);
    }
}
