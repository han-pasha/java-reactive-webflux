package com.reactiveweb.reactiveprogramming.service.impl;

import com.reactiveweb.reactiveprogramming.model.Ticket;
import com.reactiveweb.reactiveprogramming.repository.TicketRepo;
import com.reactiveweb.reactiveprogramming.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    final  Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepo ticketRepo;

    public <T> void ErrorMessage(T message) {
        System.out.println("This is error message from: " + message);
    }


    @Override
    public Mono<ServerResponse> createTicket(ServerRequest request) {
        Mono<Ticket> ticket = request.bodyToMono(Ticket.class)
                .flatMap(tiket -> ticketRepo.save(tiket))
                .doOnSuccess(x -> LOGGER.info("Ticket {} Saved", x.getName()))
                .doOnError(this::ErrorMessage);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .hint("Welp", ticket)
                .body(ticket, Ticket.class);
    }

    @Override
    public Mono<ServerResponse> updateTicket(ServerRequest request) {
        Mono<Ticket> ticket = request.bodyToMono(Ticket.class);
        return ServerResponse.ok().body(ticket, Ticket.class);
    }

    @Override
    public Mono<ServerResponse> getTicketByName(ServerRequest request) {
        Mono<Ticket> ticket = ticketRepo.findByName(request.pathVariable("ticketName"))
                .doOnSuccess(x -> LOGGER.info("Ticket {} Updated", x.getName()))
                .doOnError(this::ErrorMessage)
                .switchIfEmpty(Mono.empty());
        return ServerResponse.ok().body(ticket, Ticket.class);
    }

    @Override
    public Mono<ServerResponse> getAllTicket(ServerRequest request) {
        return null;
    }

    @Override
    public void deleteTicket(ServerRequest request) {

    }
}
