package com.atvAval01.atvAval.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atvAval01.atvAval.entities.Funcionario;
import com.atvAval01.atvAval.services.FuncionarioService;


@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public List<Funcionario> procuraTodos() {
		return service.procuraTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Funcionario procuraPorId(@PathVariable Integer id) {
		return service.procuraPorId(id);
	}
	
	@PostMapping
	public String adicionaFuncionario(@RequestBody Funcionario funcionario) {
		return service.adicionaFuncionario(funcionario);
	}
	
	@PutMapping(value = "/{id}")
	public String editarFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
		return service.editarFuncionario(id, funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void excluirFuncionario(@PathVariable Integer id) {
		service.excluirFuncionario(id);
	}
}