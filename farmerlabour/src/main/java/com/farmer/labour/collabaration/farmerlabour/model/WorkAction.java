package com.farmer.labour.collabaration.farmerlabour.model;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(WorkActionPrimaryKey.class)
public class WorkAction {
    
    @Id
    private String workId;
    @Id
    private String farmerName;
    @Id
    private String labourName;
    private  Date actionStartDate;
    private  Date actionEndDate; 
}



