package com.poc.blackfish.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "user_cpf", length = 11)
    private String cpf;

    @Column(name = "user_rg")
    private String rg;

    @Column(name = "user_date_of_birth")
    private LocalDate dateOfBirth;

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

    public User(Long id, String name, String phone, String email, String cpf, String rg, LocalDate dateOfBirth, boolean adm) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.adm = adm;
    }

}
