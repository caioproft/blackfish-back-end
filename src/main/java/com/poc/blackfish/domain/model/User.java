package com.poc.blackfish.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_cpf")
    private String cpf;

    @Column(name = "user_rg")
    private String rg;

    @Column(name = "user_adm")
    boolean adm;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Address userAddres;

    @Column(name = "user_created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "user_updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
