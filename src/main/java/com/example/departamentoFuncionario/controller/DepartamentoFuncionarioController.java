package com.example.departamentoFuncionario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.departamentoFuncionario.domain.Departamento;
import com.example.departamentoFuncionario.domain.Funcionario;
import com.example.departamentoFuncionario.repository.DepartamentoRepository;
import com.example.departamentoFuncionario.repository.FuncionarioRepository;

@RestController
public class DepartamentoFuncionarioController {
    
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // GET e POST para endpoint ---> /departamentos

    @GetMapping("/departamentos")
    public Iterable<Departamento> getDepartamentos() {
        return departamentoRepository.findAll();
    }

    @PostMapping("/departamentos")
    public void postDepartamento(@RequestBody Departamento d) {
        departamentoRepository.save(d);
    }

    // GET, POST e DELETE para endpoint ---> /departamentos/{depId}

    @GetMapping("/departamentos/{depId}")
    public Optional<Departamento> getDepartamentoById(@PathVariable(name = "depId") Long id) {
        return departamentoRepository.findById(id);
    }

    @PutMapping("/departamentos/{depId}")
    public void postDepartamentoById(@PathVariable(name = "depId") Long id, @RequestBody Departamento d) {
        if (!departamentoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
        }

        d.setId(id);
        departamentoRepository.save(d);
    }

    @DeleteMapping("/departamentos/{depId}")
    public void deleteDepartamento(@PathVariable(name = "depId") Long id) {
        departamentoRepository.deleteById(id);
    }

    // GET e POST para endpoint ---> /departamentos/{depId}/funcionarios

    @GetMapping("/departamentos/{depId}/funcionarios")
    public Iterable<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping("/departamentos/{depId}/funcionarios")
    public void postFuncionario(@RequestBody Funcionario f) {
        funcionarioRepository.save(f);
    }

}
