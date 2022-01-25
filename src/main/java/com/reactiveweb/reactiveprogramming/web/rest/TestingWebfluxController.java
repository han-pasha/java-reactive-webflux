//package com.reactiveweb.reactiveprogramming.web.rest;
//
//import com.reactiveweb.reactiveprogramming.model.Ticket;
//import com.reactiveweb.reactiveprogramming.service.TicketService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api/v1/webflux")
//public class TestingWebfluxController {
//
//    final Logger LOGGER = LoggerFactory.getLogger(TestingWebfluxController.class);
//    @Autowired
//    private TicketService ticketService;
//
//    @PostMapping("/create/ticket")
//    private Mono<Ticket> saveTicket(@RequestBody Ticket ticket) {
//        LOGGER.debug("This is the ticket {}, {}, {}",ticket.getId(),ticket.getName(), ticket.getApprover());
//        return ticketService.createTicket(ticket);
//    }
//}
