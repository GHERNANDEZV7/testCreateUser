package cl.springboot.rest.usuarioapirest.model.entity;

public class Status {

	private int codigo;
	private String Descripcion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
