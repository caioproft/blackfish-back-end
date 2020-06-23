package com.poc.blackfish.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {
    private String name;
    private String phone;
    private String email;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private boolean adm;
}
