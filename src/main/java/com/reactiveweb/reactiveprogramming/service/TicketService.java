package com.reactiveweb.reactiveprogramming.service;

import com.reactiveweb.reactiveprogramming.model.Ticket;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TicketService {
//    Mono<Ticket> createTicket(ServerRequest request);
//    Mono<Ticket> updateTicket(ServerRequest request);
//    Mono<Ticket> getTicket(ServerRequest request);
//    void deleteTicket(ServerRequest request);

    Mono<ServerResponse> createTicket(ServerRequest request);
    Mono<ServerResponse> updateTicket(ServerRequest request);
    Mono<ServerResponse> getTicketByName(ServerRequest request);
    Mono<ServerResponse> getAllTicket(ServerRequest request);
    void deleteTicket(ServerRequest request);
}
