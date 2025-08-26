package com.demo.bidding.service;

import com.demo.bidding.dto.BiddingDTO;
import com.demo.bidding.events.publisher.CustomEventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    private final CustomEventPublisher customEventPublisher;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public EventService(CustomEventPublisher customEventPublisher) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.customEventPublisher = customEventPublisher;
    }

    @Scheduled(fixedRate = 5000, initialDelay = 60000)
    public void generateEvent() {
        logger.info("Job started to receive the data from http call");
        try {
            String json = restTemplate.getForObject("https://raw.githubusercontent.com/rsrana78/demo-bidding-project/main/sample.json", String.class);
            BiddingDTO dto = objectMapper.readValue(json, BiddingDTO.class);
            customEventPublisher.publishEvent(dto);
            logger.info("Event published.{}", dto);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e){
            logger.error("Exception occurred while fetching the data from http call", e);
        }
    }
}
