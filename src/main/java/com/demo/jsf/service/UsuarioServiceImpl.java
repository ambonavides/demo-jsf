package com.demo.jsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jsf.model.entity.Usuario;
import com.demo.jsf.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void create(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario read(Long id) {
		return this.usuarioRepository.findById(id).get();
	}

	@Override
	public void update(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		
	}

	@Override
	public void delete(Long id) {
		this.usuarioRepository.deleteById(id);
		
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public List<Usuario> findByNome(String nome) {
		return this.usuarioRepository.findByNome(nome);
	}

}
