package com.api.scheduler;

import com.api.dto.JokeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    public JokeScheduler(JmsTemplate jmsTemplate, ObjectMapper objectMapper,
                               @Value("${destination.sendEmails}") String emailQueueDestination) {

        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
        this.emailQueueDestination = emailQueueDestination;
    }

    @Scheduled(initialDelay = 10000, fixedRate = 10000)
    public void getJoke() throws JsonProcessingException {
    	
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<JokeDto> response = norisApiClient.exchange("localhost:8081", HttpMethod.GET,entity,JokeDto.class);
            if (response.getStatusCode().equals(HttpStatus.OK))
                jmsTemplate.convertAndSend(emailQueueDestination, objectMapper.writeValueAsString(response.getBody().getValue()));

            System.out.println(response);
        } catch (Exception ex) {
           ex.printStackTrace();

        }
    }
}
