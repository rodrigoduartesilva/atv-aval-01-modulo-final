package com.atvAval01.atvAval.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atvAval01.atvAval.entities.Funcionario;
import com.atvAval01.atvAval.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> procuraTodos(){
		return repository.findAll();
	}
	
	public Funcionario procuraPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public String adicionaFuncionario(Funcionario funcionario) {
		repository.save(funcionario);
		return "O Funcionário foi adicionado com sucesso.";
	}
	
	public String editarFuncionario(Integer id, Funcionario funcionario) {
		Funcionario response = repository.findById(id).get();
		
		response.setNome(funcionario.getNome());
		response.setEmail(funcionario.getEmail());
		response.setSenha(funcionario.getSenha());
		response.setSalario(funcionario.getSalario());
		
		repository.save(response);
		return "Os dados do Funcionário foram atualizados com sucesso.";
	}
	
	public void excluirFuncionario(Integer id) {
		Funcionario response = repository.findById(id).get();
		repository.delete(response);
	}
}