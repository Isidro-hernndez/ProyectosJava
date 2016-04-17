package modelo;

import java.util.Date;
import java.util.ArrayList;

public class Estacionamiento {
	private String nombre;
	private String domicilio;
	private String propietario;
	private String rfc;
	private Date horaApertura;
	private Date horaCierre;
	private int noCajones;
	private Empleado []empleados;
	private Cajon []cajones;
	private ArrayList<Servicio> servicios;
	private ArrayList<Servicio> serviciosConcluidos;
	
	public Estacionamiento() {		
		String []nombres = {"Pancho Pantera",
										"El Conejo Quik",
										"Sam el Tucán",
										"El Tigre Toño",
										"Barbie"};
		int []noEmpleados = {23, 456, 1289, 567, 30};
		nombre = "Estacionamiento 'El cobrador'";
		domicilio = "";
		propietario = "";
		rfc = "";
		horaApertura = new Date(0,0,0,8,0);
		horaCierre = new Date(0,0,0,21,0);
		noCajones = 20;
		empleados = new Empleado[5];
		for(int i=0; i<empleados.length; i++) {
			if ((i < nombres.length) && (i < noEmpleados.length))
				empleados[i] = new Empleado(this, nombres[i], noEmpleados[i]);			
		}
		
		cajones = new Cajon[noCajones];
		for(int i=0; i<cajones.length;i++)
			cajones[i] = new Cajon(i+1);
		
		servicios = new ArrayList<Servicio>();
		serviciosConcluidos = new ArrayList<Servicio>();
	}
	
	public Estacionamiento(String nombre) {
		this.nombre = nombre;
		domicilio = "";
		propietario = "";
		rfc = "";
		horaApertura = new Date(0,0,0,8,0);
		horaCierre = new Date(0,0,0,21,0);
		noCajones = 0;
		empleados = new Empleado[0];
		cajones = new Cajon[noCajones];
		servicios = new ArrayList<Servicio>();
		serviciosConcluidos = new ArrayList<Servicio>();
	}
	
	public Estacionamiento(String nombre, String propietario) {
		this.nombre = nombre;
		domicilio = "";
		this.propietario = propietario;
		rfc = "";
		horaApertura = new Date(0,0,0,8,0);
		horaCierre = new Date(0,0,0,21,0);
		noCajones = 0;
		empleados = new Empleado[0];
		cajones = new Cajon[noCajones];
		servicios = new ArrayList<Servicio>();
		serviciosConcluidos = new ArrayList<Servicio>();
	}
	
	public boolean agregarServicio(Servicio servicio, int noCajon, int noEmpleado) {
		Cajon cajon = cajones[noCajon-1];
		Empleado emp = null;
		for(Empleado empleado : empleados)
			if (empleado.getNoEmpleado() == noEmpleado) {
				emp = empleado;
				break;
			}
		
		if ((cajon.isDisponible()) && (emp != null)) {		
			cajon.setDisponible(false);
			servicio.setEmpleadoRegistra(emp);
			servicio.setCajon(cajon);
			servicio.setEntrada(new Date());
			servicios.add(servicio);
			return true;
		} else
			return false;
	}
	
	public void concluirServicio(Servicio servicio, Date salida, int noEmpleadoCobra) {
		//long msDif = salida.getTime() - servicio.getEntrada().getTime();
		//Date dif = new Date(msDif);		
		Empleado emp = null;
		for(Empleado empleado : empleados)
			if (empleado.getNoEmpleado() == noEmpleadoCobra) {
				emp = empleado;
				break;
			}
		
		if (emp != null) {
			int noHoras = (int) salida.getHours() - servicio.getEntrada().getHours();
			if (salida.getMinutes() - servicio.getEntrada().getMinutes() > 0)
				noHoras++;
			double costo = noHoras * servicio.getTipo().getCostoPorHora();
			servicio.setCosto(costo);
			servicio.setNoHoras(noHoras);
			servicio.setSalida(salida);
			servicio.setEmpleadoCobra(emp);
			servicios.remove(servicio);
			serviciosConcluidos.add(servicio);
			Cajon cajon = servicio.getCajon();
			cajon.setDisponible(true);
		}
	}
	
	/*public double corteCaja(Date fecha, Empleado emp) {
		
	}
	
	public double ventasDia(Date fecha) {
		
	}*/
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		nombre = nombre.trim().toUpperCase();
		if ((nombre != null) && (!nombre.equals("")))
			this.nombre = nombre;
	}
	
	
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Date getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(Date horaApertura) {
		this.horaApertura = horaApertura;
	}

	public Date getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(Date horaCierre) {
		this.horaCierre = horaCierre;
	}

	public int getNoCajones() {
		return noCajones;
	}

	public void setNoCajones(int noCajones) {
		this.noCajones = noCajones;
	}

	@Override
	public String toString() {
		String cad = "Soy el estacionamiento: "+nombre;
		cad += "\n--------------------------------------------------------\n";
		for(Empleado empleado : empleados)
			cad += String.format("\t%05d %s\n", empleado.getNoEmpleado(), empleado.getNombre());
		cad += "\n--------------------------------------------------------\n";
		for(Cajon cajon : cajones) {
			String cadDisponible = (cajon.isDisponible() ? "Disponible" : "No disponible");
			cad += String.format("\t%02d %s\n", cajon.getNumero(), cadDisponible);
		}
		cad += "\n--------------------------------------------------------\n";
		for(Servicio serv : servicios) {
			String cadFechaEntrada = String.format("%02d/%02d/%4d %02d:%02d", 
					serv.getEntrada().getDate(), 
					serv.getEntrada().getMonth()+1,
					serv.getEntrada().getYear()+1900, 
					serv.getEntrada().getHours(), 
					serv.getEntrada().getMinutes());
			cad += String.format("\t%s %s %s %s - %s -  %s %s %s\n", serv.getMarca(), serv.getModelo(), 
					serv.getColor(), serv.getPlacas(), serv.getCajon(), cadFechaEntrada, serv.getTipo(), serv.getEmpleadoRegistra());
		}
		return cad;
	}
	
}