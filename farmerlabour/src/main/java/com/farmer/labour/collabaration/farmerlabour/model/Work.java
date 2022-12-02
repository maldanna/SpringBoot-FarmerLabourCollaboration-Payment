package com.farmer.labour.collabaration.farmerlabour.model;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WorkPrimaryKey.class)
public class Work {

    @Id
    @GeneratedValue
    private int workId;
    @Id
    private String farmerPhone;
    private String workName;
    private String workAddress;
    private String noOfdays;
    private int amountPerDay;
    private Date startDate;
    private Date endDate;
   
}
