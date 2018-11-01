package io.vipin.dtc;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;

@SpringBootApplication
@EnableJms
public class JmsMessagingServiceApplication {
	
	@Bean
	public JmsListenerContainerFactory<?> myFactory(
	    ConnectionFactory connectionFactory,
	    DefaultJmsListenerContainerFactoryConfigurer configurer) {
	  DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	  // anonymous class
	  factory.setErrorHandler(
	      new ErrorHandler() {
	        @Override
	        public void handleError(Throwable t) {
	          System.err.println("An error has occurred in the transaction");
	        }
	      });
	  // lambda function
	  factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));
	  configurer.configure(factory, connectionFactory);
	  return factory;
	}

	    @Bean 
	    // Serialize message content to json using TextMessage
	    public MessageConverter jacksonJmsMessageConverter() {
	        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	        converter.setTargetType(MessageType.TEXT);
	        converter.setTypeIdPropertyName("_type");
	        return converter;
	    }

	public static void main(String[] args) {
		SpringApplication.run(JmsMessagingServiceApplication.class, args);
       
	}
}
