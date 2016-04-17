package modelo;

public class Empleado {
	private int noEmpleado;
	private String nombre;
	private Estacionamiento est;
	
	public Empleado() {
		this.nombre = "";
		this.noEmpleado = 0;
		this.est = null;
	}
	
	public Empleado(Estacionamiento est, String nombre, int noEmpleado) {
		this.nombre = nombre;
		this.noEmpleado = noEmpleado;
		this.est = est;
	}

	public int getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(int noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estacionamiento getEst() {
		return est;
	}

	public void setEst(Estacionamiento est) {
		this.est = est;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
