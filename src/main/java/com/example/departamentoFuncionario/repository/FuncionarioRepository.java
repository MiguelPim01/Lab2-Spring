package com.example.departamentoFuncionario.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.departamentoFuncionario.domain.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
   
}
