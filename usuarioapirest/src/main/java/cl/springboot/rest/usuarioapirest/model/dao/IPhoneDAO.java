package cl.springboot.rest.usuarioapirest.model.dao;

import org.springframework.data.repository.CrudRepository;

import cl.springboot.rest.usuarioapirest.model.entity.Phones;

public interface IPhoneDAO extends CrudRepository<Phones, Long>{

}
