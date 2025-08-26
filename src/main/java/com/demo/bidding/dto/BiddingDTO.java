package com.demo.bidding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddingDTO implements Serializable {

    private String message;
    private String timeStamp;
    private int bid;
    private BigDecimal ask;
    private int volume;

}
