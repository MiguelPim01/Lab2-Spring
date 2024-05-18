package com.example.departamentoFuncionario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioDTO {
    
    private Long id;
    private String nome;
    private Double salario;

}
