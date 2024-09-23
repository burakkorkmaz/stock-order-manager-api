package com.mybroker.stockordermanagerapi.entity;

import com.mybroker.stockordermanagerapi.model.AuthRole;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private Integer status;

    private Double totalBalance;

    private LocalDateTime createDate;
}
