package com.practice.model.soap.head;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mark Wang
 * @date 2022/3/24 1:07 PM
 */
@Data
public class Response implements Serializable {
    private String standardVersionCode;
    private Integer maxRecord;
    private String TransRefGUID;
    private String TransactionCode;
    private String defaultCurrencyCode;
    private String messageId;
    private String CorrelationId;
    private Date messageDateTime;
    private String senderCode;
    private String senderName;
    private String senderAddress;
    private String receiverCode;
    private String receiverName;
    private String receiverAddress;
    private String intermediaryCode;
    private String intermediaryName;
    private String intermediaryAddress;
}
