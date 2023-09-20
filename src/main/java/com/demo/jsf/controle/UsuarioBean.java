package com.demo.jsf.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.demo.jsf.model.entity.Usuario;
import com.demo.jsf.model.enums.SexoEnum;
import com.demo.jsf.service.UsuarioService;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Component
@Scope(value = "session")
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8916141267305356353L;
	
	private String nome;

	private Usuario usuario;
	
	private Usuario usuarioSelectec;
	
	private List<Usuario> usuarios;
	
	private List<SelectItem> listaSexo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
		this.usuarioSelectec = new Usuario();
		this.usuarios = usuarioService.findAll();
		carregarSexo();
	}

	private void carregarSexo() {
		this.listaSexo = new ArrayList<SelectItem>();
		this.listaSexo.add(new SelectItem(SexoEnum.FEMININO));
		this.listaSexo.add(new SelectItem(SexoEnum.MASCULINO));
		this.listaSexo.add(new SelectItem(SexoEnum.OUTROS));
	}
	
	public void carregarIncluir() {
		this.usuario = new Usuario();
	}
	
	public void pesquisar() {
		if(StringUtils.isNotBlank(nome)) {
			this.usuarios = usuarioService.findByNome(nome);
		}else {
			this.usuarios = usuarioService.findAll();
		}
	}
	
	
	public void incluir() {
		this.usuarioService.create(usuario);
		this.init();
	}

	public void carregarEditar() {
		this.usuarioSelectec = new Usuario();
	}
	
	public void alterar() {
		this.usuarioService.create(usuario);
	}
	
	public void excluir() {
		this.usuarioService.delete(usuario.getId());
		this.init();
	}

    
}