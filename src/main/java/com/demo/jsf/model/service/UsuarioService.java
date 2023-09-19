package com.demo.jsf.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.jsf.model.entity.Usuario;

@Service
public interface UsuarioService {
	
    void create(Usuario usuario);
    Usuario read(Long id);
    void update(Usuario usuario);
    void delete(Long id);
    List<Usuario> findAll();
    List<Usuario> findByNome(String nome);

}
