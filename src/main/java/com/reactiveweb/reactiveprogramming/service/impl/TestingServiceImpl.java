package com.reactiveweb.reactiveprogramming.service.impl;

import com.reactiveweb.reactiveprogramming.model.TestingModel;
import com.reactiveweb.reactiveprogramming.repository.TestingRepo;
import com.reactiveweb.reactiveprogramming.service.TestingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TestingServiceImpl implements TestingService {

    /**
     * THIS REPO COULDN'T BE AUTO WIRED BECAUSE
     * R2DBC DOESN'T ALLOW BEAN ON ITS REPO
     */
    private TestingRepo testingRepo;

    @Override
    public Mono<TestingModel> createTestingModel(TestingModel model) {
        return testingRepo.save(model);
    }
}
