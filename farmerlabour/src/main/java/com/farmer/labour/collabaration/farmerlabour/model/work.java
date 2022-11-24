package com.farmer.labour.collabaration.farmerlabour.model;

import javax.persistence.Entity;
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
public class work {

    @Id
    private String workId;
    @Id
    private String farmerName;
    private String workName;
    private String workAddress;
    private String noOfdays;
    private int amountPerDay;

    
}
