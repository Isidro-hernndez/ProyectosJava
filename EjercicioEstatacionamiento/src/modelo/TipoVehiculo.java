package modelo;

public abstract class TipoVehiculo {
	protected String nombre;
	protected double costoPorHora;
	
	public String getNombre() {
		return nombre;
	}
	public double getCostoPorHora() {
		return costoPorHora;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
}
