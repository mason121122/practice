package com.practice.model.soap.message;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mark Wang
 * @date 2022/3/24 1:17 PM
 */
@Data
public class StaffInformation implements Serializable {
    private String id;
    private String hHouseholdName;
    private String gender;
    private String nation;
    private Date birthday;
    private String householdAttribute;
    private String town_or_Village_Num;
    private String birthplace;
    private String maritalStatus;
    private String healthState;
    private String newBorn_Flag;
    private String nrcID;
    private String personalID;
    private String zipCode;
    private String telephone;
    private String workUnit;
    private String districtCode;
    private String districtName;
    private String insuranceType;
    private String medPersonType;
    private String insurancePolicy;
    private String insurPo_BeginDat;
    private Date insurPo_EndDate;
    private String year;
    private String familyCode;
    private String householdCode;
    private String hhouseholdID;
    private String groupNum;
    private String familyAmount;
    private String agriculturalAmount;
    private String homeAddress;
    private String name;
    private String familyRelations;
}
