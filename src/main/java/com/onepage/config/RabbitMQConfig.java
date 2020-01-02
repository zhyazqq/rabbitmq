package com.onepage.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMQConfig {
//	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cFactory = new CachingConnectionFactory();
		//ÉèÖÃIP¶Ë¿Ú
		cFactory.setAddresses("192.168.10.104:1521");
		
		cFactory.setUsername("guest");
		cFactory.setPassword("guest");
		cFactory.setVirtualHost("/");
		cFactory.setPublisherConfirms(true);
		return cFactory;
		
	}
}
