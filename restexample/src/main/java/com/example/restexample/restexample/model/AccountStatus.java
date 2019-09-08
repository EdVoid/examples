package com.example.restexample.restexample.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String accountid;

    private String status;

    private String origin;

    @CreationTimestamp
    private Date lastUpdate;
}
