package br.com.messagin.jms.mensageria.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.messagin.jms.mensageria.model.Mensagem;

@Component
public class Receiver {
	
	@JmsListener(destination = "caixaDeMensagem")
	public void receiveMessage(Mensagem mensagem){
		System.out.println("Recebido <" + mensagem + ">F");
	}

}
