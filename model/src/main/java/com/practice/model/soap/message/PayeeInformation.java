package com.practice.model.soap.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mark Wang
 * @date 2022/3/24 1:26 PM
 */
@Data
public class PayeeInformation implements Serializable {

    private String customerType;
    private String customerNature;
    private String bankType;
}
