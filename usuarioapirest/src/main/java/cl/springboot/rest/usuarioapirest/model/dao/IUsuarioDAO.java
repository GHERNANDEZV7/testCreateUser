package cl.springboot.rest.usuarioapirest.model.dao;

import org.springframework.data.repository.CrudRepository;


import cl.springboot.rest.usuarioapirest.model.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

}
