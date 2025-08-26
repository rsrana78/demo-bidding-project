package com.demo.bidding.service;

import com.demo.bidding.dto.BiddingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BiddingService {

    private static final Logger logger = LoggerFactory.getLogger(BiddingService.class);

    public void processEvent(final BiddingDTO biddingDTO) {
        logger.info("Processing Bidding Event with data {}", biddingDTO);
    }
}
