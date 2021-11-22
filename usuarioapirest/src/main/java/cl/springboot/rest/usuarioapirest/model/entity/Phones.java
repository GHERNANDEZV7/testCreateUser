package cl.springboot.rest.usuarioapirest.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "telefonos")
public class Phones implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Phones() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="id_phone")
	private String id;
	
	@Column(name="id_usuario")
	private String id_usuario;
	
	@Column(name="number")
	private String number;

	@Column(name="city_code")
	private String cityCode;

	@Column(name="country_code")
	private String countryCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
