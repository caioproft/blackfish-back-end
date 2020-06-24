package com.poc.blackfish.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Retention;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {

    @NotEmpty(message = "{user.name.required}")
    private String name;

    @NotEmpty(message = "{user.phone.required}")
    private String phone;

    @NotEmpty(message = "{user.email.required}")
    private String email;

    @CPF(message = "{user.cpf.invalid}.")
    @NotEmpty(message = "{user.cpf.required}")
    private String cpf;

    private String rg;

    private String dateOfBirth;

    private boolean adm;
}
