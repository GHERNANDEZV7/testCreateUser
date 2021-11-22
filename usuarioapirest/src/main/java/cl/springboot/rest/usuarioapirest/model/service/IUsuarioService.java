package cl.springboot.rest.usuarioapirest.model.service;

import cl.springboot.rest.usuarioapirest.model.entity.Usuario;
import cl.springboot.rest.usuarioapirest.model.entity.UsuarioDTO;

public interface IUsuarioService {
	

	public UsuarioDTO saveUser(UsuarioDTO user);
	public Usuario findAll();

}
