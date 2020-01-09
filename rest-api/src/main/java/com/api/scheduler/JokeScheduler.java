package com.api.scheduler;

import com.api.dto.JokeDto;
import com.api.dto.JokeMail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Coa
 * Scheduler klasa za rukovanje sa intervalima hvatanja sala
 *
 */
@Component
public class JokeScheduler {
	
	@Autowired
    private RestTemplate norisApiClient;
    private JmsTemplate jmsTemplate;
    private ObjectMapper objectMapper;
    private String emailQueueDestination;
    private JokeMail mail;

    public JokeScheduler(JmsTemplate jmsTemplate, ObjectMapper objectMapper,
                               @Value("${destination.sendEmails}") String emailQueueDestination) {

        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.emailQueueDestination = emailQueueDestination;
    }
    
    /*
     * Funkcija za periodicno cekiranje intervala za slanje korisnika
     * potrebno je izmeniti delay i rate na vrednosti manje od naseg najmanjeg moguceg intervala
     */
    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getJoke() throws JsonProcessingException {
    	
    	//proci kroz listu usera u bazi
    	
    	//za svaki pitati da l je interval prosao
    	
    	//ako jeste ide ovaj kod ispod
    	
    	
    	/*
    	 * Hvatanje najnovije sale iz baze koja se nalazi na joke 
    	 * servisu i slanje preko message broekra mail servisu
    	 * Takodje je potrebno uzeti korisnikov mail i proslediti ga mail servisu
    	 * Ovo moze da se postigne tako sto jokeDto koji fetchujemo sa api-ja posaljemo 
    	 * zajedno sa korisnickim mailom putem nove klase koja sadrzi u sebi joke i mail.
    	 * Npr JokeMail koji u sebi sadrzi samo 2 polja: salu i mail korisnika. Onda istu klasu prihvatamo u maileru i iz nje vadimo
    	 */
        try {
            ResponseEntity<JokeDto> response = norisApiClient.exchange("localhost:8081/api/joke", HttpMethod.GET,null,JokeDto.class);
			if (response.getStatusCode().equals(HttpStatus.OK))
            	mail = new JokeMail(response.getBody().getValue(), "OVDE STAVIS KORISNIKOV MAIL!!!!!!");
                jmsTemplate.convertAndSend(emailQueueDestination, objectMapper.writeValueAsString(mail));
        } catch (Exception ex) {
           ex.printStackTrace();

        }
    }
}
