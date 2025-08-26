package com.demo.bidding.events.publisher;

import com.demo.bidding.dto.BiddingDTO;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomEventPublisher {

    private final ApplicationEventPublisher eventPublisher;


    public CustomEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(BiddingDTO biddingDTO) {
        eventPublisher.publishEvent(biddingDTO);
    }
}
