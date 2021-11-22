package cl.springboot.rest.usuarioapirest.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.rest.usuarioapirest.model.dao.IPhoneDAO;
import cl.springboot.rest.usuarioapirest.model.dao.IUsuarioDAO;
import cl.springboot.rest.usuarioapirest.model.entity.Phones;
import cl.springboot.rest.usuarioapirest.model.entity.Status;
import cl.springboot.rest.usuarioapirest.model.entity.Usuario;
import cl.springboot.rest.usuarioapirest.model.entity.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	// Esto podria ir en properties para ser valor configurable
	private Boolean isValid = true;
	private Usuario user;
	private Status status;
	

	@Autowired
	private IUsuarioDAO userDAO;

	@Autowired
	private IPhoneDAO phoneDAO;

	@Override
	public UsuarioDTO saveUser(UsuarioDTO usuDTO) {

		Date date = new Date();
		try {

			//Se actualizan datos del DTO al objeto de persistencia
			user =new Usuario();
			user.setCreated(date);
			user.setModified(date);
			user.setLastLogin(date);
			user.setIsActive(isValid);
			user.setEmail(usuDTO.getEmail());
			user.setNombre(usuDTO.getNombre());
			user.setPassword(usuDTO.getPassword());
			user.setPhones(usuDTO.getPhones());
			
			
			
			
			//llamada a guardar usuario		
			userDAO.save(user);
			//devuelvo id creado 
			usuDTO.setId_usuario(user.getId());
			
			usuDTO.setCreated(date);
			usuDTO.setModified(date);
			usuDTO.setLastLogin(date);
			usuDTO.setIsActive(isValid);

			for (Phones phones : user.getPhones()) {
				// imprimimos el objeto pivote

				phones.setId_usuario(user.getId());
				phoneDAO.save(phones);
				
			}
		} catch (Exception e) {

			status.setCodigo(10);
			status.setDescripcion("Ha ocurrido un error al ingresar el usuario");
			usuDTO.setStatus(status);
			return usuDTO;
		}
		return usuDTO;

	}

	@Override
	public Usuario findAll() {
		// TODO Auto-generated method stub
		return (Usuario) userDAO.findAll();

	}

}
