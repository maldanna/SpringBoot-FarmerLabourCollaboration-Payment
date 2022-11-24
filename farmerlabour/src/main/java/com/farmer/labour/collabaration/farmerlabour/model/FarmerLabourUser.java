package com.farmer.labour.collabaration.farmerlabour.model;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private String username;
    private String name;
    private String password;
    private String email;
    private String  phone;
    private Blob image;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name="roles",
        joinColumns = @JoinColumn(name="id")
    )
    @Column(name = "role")
    private Set<String> roles;

}

