package org.dy.example.configuration;

import org.dy.example.websocket.handler.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketCfg extends AbstractWebSocketMessageBrokerConfigurer {
	
	 @Override
	 public void configureMessageBroker(MessageBrokerRegistry config) {
		 config.enableSimpleBroker("/topic");
		 config.setApplicationDestinationPrefixes("/app");
	 }
	
	   @Override
	   public void registerStompEndpoints(StompEndpointRegistry registry) {
	        registry.addEndpoint("/hello").withSockJS();
	   }
	   
	   //websocket测试
	   /*public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		   registry.addHandler(handler(), "/echo").addInterceptors(
				   new HttpSessionHandshakeInterceptor()).withSockJS();
	   }

	   @Bean
	   public WebSocketHandler handler() {
        return new WebSocketHandler();
       }*/
}
