package com.poc.blackfish.domain.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_number")
    private int number;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_state")
    private String state;

    @Column(name = "address_country")
    private String country;

    @Column(name = "addres_zipcode")
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "address_created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "address_updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
