package com.api.scheduler;

import com.api.dto.JokeDto;
import com.api.dto.JokeMail;
import com.api.model.UserSubsription;
import com.api.service.UserService;
import com.api.service.impl.SubscriptionServiceImpl;
import com.api.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
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
    private SubscriptionServiceImpl subServiceImp;
    private UserServiceImpl userServiceImp;
	private UserService userService;

    public JokeScheduler(JmsTemplate jmsTemplate, ObjectMapper objectMapper,
                               @Value("${destination.sendEmails}") String emailQueueDestination, UserService userService) {
    	this.userService = userService;
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.emailQueueDestination = emailQueueDestination;
    }
    
    /*
     * Funkcija za periodicno cekiranje intervala za slanje korisnika
     * potrebno je izmeniti delay i rate na vrednosti manje od naseg najmanjeg moguceg intervala
     */
    @Scheduled(initialDelay = 1000, fixedRate = 1000)
    public void getJoke() throws JsonProcessingException {
    	
    	/*
    	 * Komentar Gunic:
    	 * Dodati interval pri pravljenju instance,to bi trebalo staviti na mestu
    	 * gde ce biti povezan front ili bilo gde(ima vec seter za interval)
    	 */
    	PageRequest pageRequest = PageRequest.of(0, 5000);
    	List<UserSubsription> subsrciptions = subServiceImp.findAll(pageRequest);
    	
    	Date d = new Date();
    	for(UserSubsription sub : subsrciptions) {
    		if((d.getTime() - sub.getLastTimeExecuted()) > sub.getInterval()) {
    			if(sub.getServiceName().contentEquals("joke")) {
    				try {
        	            ResponseEntity<JokeDto> response = norisApiClient.exchange("localhost:8081/api/joke", HttpMethod.GET,null,JokeDto.class);
        				if (response.getStatusCode().equals(HttpStatus.OK))
        	            	mail = new JokeMail(response.getBody().getValue(), userService.findById(sub.getUserId()).getEmail());
        	                jmsTemplate.convertAndSend(emailQueueDestination, objectMapper.writeValueAsString(mail));
        	                sub.setLastTimeExecuted(d.getTime());
        	        } catch (Exception ex) {
        	           ex.printStackTrace();

        	        }
    			}
    		}
    	}
    }
}
