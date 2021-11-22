package cl.springboot.rest.usuarioapirest.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//En esta clase controladora se llaman a los metodos implementados en el servicio

import cl.springboot.rest.usuarioapirest.model.dao.IUsuarioDAO;
import cl.springboot.rest.usuarioapirest.model.entity.Status;
import cl.springboot.rest.usuarioapirest.model.entity.Usuario;
import cl.springboot.rest.usuarioapirest.model.entity.UsuarioDTO;
import cl.springboot.rest.usuarioapirest.model.service.IUsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	// Registro interfaz Service para poder implementar metodo save
	@Autowired
	private IUsuarioService userService;

	//Registro de interfaz de acceso de datos usuario
	@Autowired
	private IUsuarioDAO userDao;

	private Status status = new Status();

	// Crea Usuario
	@RequestMapping(path = "/createuser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UsuarioDTO> createUser(
			@Valid @RequestBody UsuarioDTO user,
			BindingResult result) {
		if (result.hasErrors()) {

			//Valida que el campo Email y Password cumplan con lo minimo requerido del objeto UsuarioDTO a través de @Valid 
			for(FieldError errores :result.getFieldErrors()){
				status.setCodigo(100);
				status.setDescripcion("Error en datos de entrada, revisar campo "+errores.getField()+", "+errores.getDefaultMessage());
				
			}
						
			user.setStatus(status);
			return new ResponseEntity<UsuarioDTO>(user, HttpStatus.BAD_REQUEST);
		} else {

			try {
					user = userService.saveUser(user);
					status.setCodigo(0);
					status.setDescripcion("Usuario ingresado exitosamente");
					user.setStatus(status);
					return new ResponseEntity<UsuarioDTO>(user, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<UsuarioDTO>(user, HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	// Metodo para veridficar usuarios creados en BD
	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public Iterable<Usuario> listarUsuario() {

		return userDao.findAll();
	}

}
