package br.com.messagin.jms.mensageria;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import br.com.messagin.jms.mensageria.model.Mensagem;

@SpringBootApplication
@EnableJms
public class MensageriaApplication {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		configurer.configure(factory, connectionFactory);
		
		return factory;
	}
	
	@Bean
	public MessageConverter jacksonJmsMEssageConverter(){
		
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		
		return converter;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MensageriaApplication.class, args);
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		System.out.println("Enviando mensagem...");
		jmsTemplate.convertAndSend("caixaDeMensagem", new Mensagem("contato@contato.com", "Corpo da mensagem!!!"));
	}
}
