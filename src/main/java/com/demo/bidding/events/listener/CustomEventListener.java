package com.demo.bidding.events.listener;

import com.demo.bidding.dto.BiddingDTO;
import com.demo.bidding.service.BiddingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomEventListener.class);

    private final BiddingService biddingService;

    public CustomEventListener(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @EventListener
    public void handleInvoiceEvent(Object event) {
        if(event instanceof BiddingDTO){
            logger.info("Bidding Event Received");
            biddingService.processEvent((BiddingDTO) event);
        }
    }


}

