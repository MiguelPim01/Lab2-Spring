package com.example.departamentoFuncionario.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.departamentoFuncionario.domain.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
   
}
