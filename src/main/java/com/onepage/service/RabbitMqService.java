package com.onepage.service;

import javax.sound.midi.Soundbank;

import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Service
public class RabbitMqService {
	private final static String QUEUE_NAME = "topic";

	public String getResult() throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");// guest用户只能写localhost
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setVirtualHost("/");
		factory.setPort(5672);
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			System.out.println(channel);
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "fffffffff'");
		}
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
		};
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { 
//        	
//        	System.out.println(deliverCallback);
//        	System.out.println(consumerTag);
//        });
		String string=channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag->{
			consumerTag.getBytes();
			System.out.println(consumerTag.getBytes());
		});
		System.out.println(string);
		return "success";
	}
}
