package org.zupzup.kotlinwebfluxdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import org.zupzup.kotlinwebfluxdemo.PrimeNumbersHandler

@Configuration
@EnableWebFlux
@ComponentScan(value = ["org.zupzup.kotlinwebfluxdemo"])
class WebSocketConfig(
        val primeNumbersHandler: PrimeNumbersHandler
) {
    @Bean
    fun websocketHandlerAdapter() = WebSocketHandlerAdapter()

    @Bean
    fun handlerMapping() : HandlerMapping {
        val handlerMapping = SimpleUrlHandlerMapping()
        handlerMapping.urlMap = mapOf(
                "/ws/primes" to primeNumbersHandler
        )
        handlerMapping.order = 1
        return handlerMapping
    }
}