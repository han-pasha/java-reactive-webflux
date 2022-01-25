package com.reactiveweb.reactiveprogramming.web.rest;

import com.reactiveweb.reactiveprogramming.handler.CustomerHandler;
import com.reactiveweb.reactiveprogramming.handler.CustomerStreamHandler;
import com.reactiveweb.reactiveprogramming.model.Ticket;
import com.reactiveweb.reactiveprogramming.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;
    @Autowired
    private CustomerStreamHandler customerStreamHandler;
    @Autowired
    private TicketService ticketService;

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route()
                .GET("/api/get/customer", customerHandler::loadCustomers)
                .GET("/api/get/customer/stream", customerStreamHandler::getCustomersStream)
                .GET("/api/get/customer/testinput/{input}", customerHandler::inputCustomer)
                .POST("/api/post/customer", customerHandler::saveCustomer)
                .POST("/api/post/testing", customerHandler::saveTesting)
                .GET("/api/get/ticket/{ticketName}", ticketService::getTicketByName)
                .POST("/api/post/ticket", ticketService::createTicket)
                .build();

    }
}
