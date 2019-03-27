package com.mailsender.config;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.DestinationConfigurer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {

	@Value("${pdf.rabbitmq.exchange}")
	private  String exchange;

	@Value("${pdf.rabbitmq.routingkey}")
	private  String routingKey;
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange, true, false);
	}
	
	@Bean
	public DestinationConfigurer getDestinationConfigurer(DirectExchange exchange)
	{
		return BindingBuilder.bind(exchange);
	}


	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate myrabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
	
	@Bean
	public CachingConnectionFactory myCachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("YOUR-RABBIT_MQ-HOST-URL");
		connectionFactory.setUsername("RABBIT_MQ-USERNAME");
		connectionFactory.setPassword("RABBIT_MQ-PASSWORD");
		connectionFactory.setVirtualHost("RABBIT_MQ-VIRTUAL-HOST(IF ANY)");
		return(connectionFactory);
	}
}
