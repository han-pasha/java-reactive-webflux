package com.reactiveweb.reactiveprogramming.repository;

import com.reactiveweb.reactiveprogramming.model.Ticket;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface TicketRepo extends R2dbcRepository<Ticket, Long> {
    Mono<Ticket> findByName(String name);
}
