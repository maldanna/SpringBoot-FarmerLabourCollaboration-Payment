package com.farmer.labour.collabaration.farmerlabour.model;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerLabourUser{

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name="roles",
        joinColumns = @JoinColumn(name="id")
    )
    @Column(name = "role")
    private Set<String> roles;

}