package com.youssadi.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Configuration
public class MyFilter implements GlobalFilter {
    Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /** pre filter */
        ServerHttpRequest request = exchange.getRequest();
        String uri = request.getURI().toString();
        logger.info("uri entete = " + request.getHeaders().getFirst("uri"));
        return chain.filter(exchange).then(
                Mono.fromRunnable(
                        ()->{
                            /** post filter */
                            ServerHttpResponse response = exchange.getResponse();
                            logger.info("le code de réponse = " + response.getStatusCode()
                            );
                        }
                )
        );
    }
}
