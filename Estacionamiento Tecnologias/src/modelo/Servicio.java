package modelo;
import java.util.Date;

public class Servicio {
	private Date entrada;
	private Date salida;
	private String placas;
	private String modelo;
	private String marca;
	private String color;
	private Empleado empleadoRegistra;
	private Empleado empleadoCobra;
	private Cajon cajon;
	private TipoVehiculo tipo;
	private double costo;
	private int noHoras;
	private int folio;
	
	
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Empleado getEmpleadoRegistra() {
		return empleadoRegistra;
	}
	public void setEmpleadoRegistra(Empleado empleadoRegistra) {
		this.empleadoRegistra = empleadoRegistra;
	}
	public Empleado getEmpleadoCobra() {
		return empleadoCobra;
	}
	public void setEmpleadoCobra(Empleado empleadoCobra) {
		this.empleadoCobra = empleadoCobra;
	}
	public Cajon getCajon() {
		return cajon;
	}
	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}
	public TipoVehiculo getTipo() {
		return tipo;
	}
	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getNoHoras() {
		return noHoras;
	}
	public void setNoHoras(int noHoras) {
		this.noHoras = noHoras;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	
	
	
}
