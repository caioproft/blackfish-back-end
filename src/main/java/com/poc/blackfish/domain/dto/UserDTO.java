package com.poc.blackfish.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {

    @NotEmpty(message = "É preciso informar um nome.")
    private String name;

    @NotEmpty(message = "É preciso informar um telefone para contato.")
    private String phone;

    @NotEmpty(message = "É preciso informar o e-mail.")
    private String email;

    @CPF(message = "O CPF informado não é valido.")
    @NotEmpty(message = "É preciso informar o CPF.")
    private String cpf;

    private String rg;

    private String dateOfBirth;

    private boolean adm;
}
