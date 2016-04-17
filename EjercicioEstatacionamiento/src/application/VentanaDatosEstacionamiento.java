package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Empleado;

import java.util.Optional;


public class VentanaDatosEstacionamiento extends Stage {
	private VBox contenidoDatos;
	private BorderPane contenidoEmpleados;
	private TableView tablaEmpleados;
	private TextField txtNoEmpleado, txtNombre;	
	private TitledPane panelEdicion;
	private VBox contenedorSuperior;
	private Button btnAgregar, btnModificar, btnEliminar;
	
	private boolean nuevoEmpleado = false;
	private ObservableList<Empleado> listaEmpleados;
	private Empleado empleadoActual;
	
	public VentanaDatosEstacionamiento() {
		TabPane tabs = new TabPane();
		Tab tabDatos = new Tab("Datos Generales");
		tabDatos.setClosable(false);
		Tab tabEmpleados = new Tab("Empleados");
		tabEmpleados.setClosable(false);
		tabs.getTabs().addAll(tabDatos, tabEmpleados);
		
		contenidoDatos = new VBox();
		contenidoEmpleados = new BorderPane();
		tabDatos.setContent(contenidoDatos);
		tabEmpleados.setContent(contenidoEmpleados);
		
		Scene escenaEstacionamiento = new Scene(tabs, 500, 400);
		this.setScene(escenaEstacionamiento);
		this.setTitle("Captura de Datos del Estacionamiento");
		
		crearComponentesDatos();
		crearComponentesEmpleados();
		
		habilitarEdicionEmpleado(false);
	}
	
	private void crearComponentesEmpleados() {		
		Button btnAceptarEmpleado, btnCancelarEmpleado;
		Label etiNoEmpleado, etiNombre;
		
		 contenidoEmpleados.setPadding(new Insets(5));
		 
		//Contenedor Superior (Tabla y Botones)
		contenedorSuperior = new VBox();		
		contenedorSuperior.setSpacing(5);
		
		//Creación de la tabla
		tablaEmpleados = new TableView(); 
		tablaEmpleados.getSelectionModel().selectedItemProperty().addListener((evento) -> {
			empleadoActual = (Empleado) tablaEmpleados.getSelectionModel().getSelectedItem();			
			cargarDatosEmpleado();
			btnModificar.setDisable(false);
			btnEliminar.setDisable(false);
		});
		listaEmpleados  =  FXCollections.observableArrayList();
		tablaEmpleados.setItems(listaEmpleados);
		tablaEmpleados.setMaxHeight(150);
		
		TableColumn colNoEmpleado = new TableColumn("No. Empleado");
		colNoEmpleado.setMinWidth(100);
		colNoEmpleado.setCellValueFactory(new PropertyValueFactory<Empleado, String>("noEmpleado"));
		
		TableColumn colNombre = new TableColumn("Nombre del Empleado");
		colNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
		colNombre.setMinWidth(300);
		
		tablaEmpleados.getColumns().addAll(colNoEmpleado, colNombre);
		
		
		//HBox para contener los botones
		HBox contenedorBotones = new HBox();
		contenedorBotones.setSpacing(5);
		//Creación de los botones		
		btnAgregar = new Button("Agregar");
		btnAgregar.setOnAction((event) -> {
			agregarEmpleado();
		});
		btnModificar = new Button("Modificar");
		btnModificar.setOnAction((event) -> {
			modificarEmpleado();
		});
		btnEliminar = new Button("Eliminar");
		btnEliminar.setOnAction((evento) -> {
			eliminarEmpleado();
		});
		contenedorBotones.getChildren().addAll(btnAgregar, btnModificar, btnEliminar);
		
		//Se llena el contenedor superior
		contenedorSuperior.getChildren().addAll(tablaEmpleados, contenedorBotones);
		
		contenidoEmpleados.setTop(contenedorSuperior);
		
		//Se crear el contenedor Central
		panelEdicion = new TitledPane();
		panelEdicion.setText("Datos del Empleado");
		panelEdicion.setCollapsible(false);
		panelEdicion.setMinHeight(150);
		
		VBox contenedorDatos = new VBox();
		HBox fila1Datos = new HBox();
		fila1Datos.setSpacing(5);
		fila1Datos.setPadding(new Insets(5));
		HBox fila2Datos = new HBox();
		fila2Datos.setSpacing(5);
		fila2Datos.setPadding(new Insets(5));
		HBox fila3Datos = new HBox();
		fila3Datos.setSpacing(5);
		fila3Datos.setPadding(new Insets(5));
		fila3Datos.setAlignment(Pos.CENTER_RIGHT);
						
		
		etiNoEmpleado = new Label("No. Empleado");
		etiNoEmpleado.setMinWidth(100);
		etiNoEmpleado.setMinHeight(25);
		etiNoEmpleado.setAlignment(Pos.CENTER_RIGHT);
		
		txtNoEmpleado = new TextField();
		txtNoEmpleado.setMinWidth(100);
		txtNoEmpleado.setPromptText("Número de empleado");
		
		etiNombre = new Label("Nombre");
		etiNombre.setMinWidth(100);
		etiNombre.setMinHeight(25);
		etiNombre.setAlignment(Pos.CENTER_RIGHT);
		
		txtNombre = new TextField();
		txtNombre.setMinWidth(300);
		txtNombre.setPromptText("Nombre del empleado");		
		
		btnAceptarEmpleado = new Button("Aceptar");
		btnAceptarEmpleado.setOnAction((event) -> {
			guardarEmpleado();
		});
		btnCancelarEmpleado = new Button("Cancelar");
		btnCancelarEmpleado.setOnAction((event) -> {
			cancelarGuardarEmpleado();
		});
		
		fila1Datos.getChildren().addAll(etiNoEmpleado, txtNoEmpleado);
		fila2Datos.getChildren().addAll(etiNombre, txtNombre);
		fila3Datos.getChildren().addAll(btnAceptarEmpleado, btnCancelarEmpleado);
		
		contenedorDatos.getChildren().addAll(fila1Datos, fila2Datos, fila3Datos);
		panelEdicion.setContent(contenedorDatos);
		//Se rellena el BorderPane de la pestaña de Empleados
		
		contenidoEmpleados.setCenter(panelEdicion);		
	}
	
	private void habilitarEdicionEmpleado(boolean hab) {
		panelEdicion.setDisable(!hab);
		contenedorSuperior.setDisable(hab);
		btnModificar.setDisable(true);
		btnEliminar.setDisable(true);
	}
	
	private void agregarEmpleado() {
		txtNoEmpleado.setText("");
		txtNombre.setText("");
		
		nuevoEmpleado = true;
		empleadoActual = new Empleado();
		habilitarEdicionEmpleado(true);
	}
	
	private void modificarEmpleado() {
		nuevoEmpleado = false;		
		habilitarEdicionEmpleado(true);
	}
	
	private void eliminarEmpleado() {
		Alert dialogo = new Alert(AlertType.CONFIRMATION);
		dialogo.setTitle("Confirmación");
		dialogo.setHeaderText("Eliminación de un Empleado");
		dialogo.setContentText("¿Está seguro de eliminar al empleado "+empleadoActual+"?");
		
		Optional<ButtonType> resultado = dialogo.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			listaEmpleados.remove(empleadoActual);
			empleadoActual = null;
			btnModificar.setDisable(true);
			btnEliminar.setDisable(true);
		}
	}
	
	private void guardarEmpleado() {		
		
			if (nuevoEmpleado)
				if (datosValidos())
					listaEmpleados.add(empleadoActual);
				else {
					Alert dialogo = new Alert(AlertType.ERROR);
					dialogo.setTitle("Error");
					dialogo.setHeaderText("No. de Empleado duplicado");
					dialogo.setContentText("Lo sentimos pero el número de empleado"+txtNoEmpleado.getText()+" ya está asociado a otro empleado. Favor de verificar");
					
					dialogo.showAndWait();
					return;
				}
			empleadoActual.setNoEmpleado(Integer.parseInt(txtNoEmpleado.getText()));
			empleadoActual.setNombre(txtNombre.getText());
		
			habilitarEdicionEmpleado(false);
		
			tablaEmpleados.refresh();
		
	}
	
	private boolean datosValidos() {
		boolean resultado = true;
		try {
			int noEmpleado = Integer.parseInt(txtNoEmpleado.getText());
			for(Empleado emp : listaEmpleados)
				if (emp.getNoEmpleado() == noEmpleado)
					resultado = false;
		} catch (Exception e) {
			resultado = false;
		}
		return resultado;
	}
	
	
	private void cancelarGuardarEmpleado() {
		habilitarEdicionEmpleado(false);
	}
	
	private void cargarDatosEmpleado() {
		if (empleadoActual != null) {
			txtNoEmpleado.setText(Integer.toString(empleadoActual.getNoEmpleado()));
			txtNombre.setText(empleadoActual.getNombre());
		}
	}
	
	private void crearComponentesDatos() {
		HBox hbNombre, hbDomicilio, hbPropietario, hbRFC, hbApertura, hbCierre, hbNoCajones, hbBotones;
		Label etiNombre, etiDomicilio, etiPropietario, etiRFC, etiApertura, etiCierre, etiNoCajones;
		TextField txtNombre, txtDomicilio, txtPropietario, txtRFC, txtNoCajones;
		Slider hsApertura, hsCierre;
		Button aceptar, cancelar;
		
		hbApertura = new HBox();
		hbApertura.setPadding(new Insets(5));
		hbApertura.setSpacing(5);
		etiApertura = new Label("Apertura: ");
		etiApertura.setMinWidth(80);
		etiApertura.setMinHeight(25);
		etiApertura.setAlignment(Pos.CENTER_RIGHT);
		hsApertura = new Slider();
		hsApertura.setOrientation(Orientation.HORIZONTAL);
		hsApertura.setMinWidth(400);
		hsApertura.setMin(0);
		hsApertura.setMax(23);
		hsApertura.setValue(7);
		hsApertura.setMajorTickUnit(1);
		hsApertura.setMinorTickCount(0);
		hsApertura.setShowTickLabels(true);
		hsApertura.setShowTickMarks(true);
		hbApertura.getChildren().addAll(etiApertura, hsApertura);
		
		hbCierre = new HBox();
		hbCierre.setPadding(new Insets(5));
		hbCierre.setSpacing(5);
		etiCierre = new Label("Cierre: ");
		etiCierre.setMinWidth(80);
		etiCierre.setMinHeight(25);
		etiCierre.setAlignment(Pos.CENTER_RIGHT);
		hsCierre = new Slider();
		hsCierre.setOrientation(Orientation.HORIZONTAL);
		hsCierre.setMinWidth(400);
		hsCierre.setMin(0);
		hsCierre.setMax(23);
		hsCierre.setValue(7);
		hsCierre.setMajorTickUnit(1);
		hsCierre.setMinorTickCount(0);
		hsCierre.setShowTickLabels(true);
		hsCierre.setShowTickMarks(true);
		hbCierre.getChildren().addAll(etiCierre, hsCierre);
		
		//No Cajones
		hbNoCajones = new HBox();
		hbNoCajones.setPadding(new Insets(5));
		hbNoCajones.setSpacing(5);
		etiNoCajones = new Label("No Cajones: ");
		etiNoCajones.setMinWidth(80);
		etiNoCajones.setMinHeight(25);
		etiNoCajones.setAlignment(Pos.CENTER_RIGHT);
		txtNoCajones = new TextField();
		txtNoCajones.setMinWidth(50);
		txtNoCajones.setPromptText("No Cajones del Estacionamiento");
		hbNoCajones.getChildren().addAll(etiNoCajones, txtNoCajones);
		
		hbBotones = new HBox();
		hbBotones.setAlignment(Pos.CENTER_RIGHT);
		hbBotones.setPadding(new Insets(5));
		hbBotones.setSpacing(5);
		aceptar = new Button("Aceptar");
		cancelar = new Button("Cancelar");
		hbBotones.getChildren().addAll(aceptar, cancelar);
		
		//Nombre del Estacionamiento
		hbNombre = new HBox();
		hbNombre.setPadding(new Insets(5));
		hbNombre.setSpacing(5);
		etiNombre = new Label("Nombre: ");
		etiNombre.setMinWidth(80);
		etiNombre.setMinHeight(25);
		etiNombre.setAlignment(Pos.CENTER_RIGHT);
		txtNombre = new TextField();
		txtNombre.setMinWidth(400);
		txtNombre.setPromptText("Nombre del Estacionamiento");
		hbNombre.getChildren().addAll(etiNombre, txtNombre);
		
		//Domicilio
		hbDomicilio = new HBox();
		hbDomicilio.setPadding(new Insets(5));
		hbDomicilio.setSpacing(5);
		etiDomicilio = new Label("Domicilio: ");
		etiDomicilio.setMinWidth(80);
		etiDomicilio.setMinHeight(25);
		etiDomicilio.setAlignment(Pos.CENTER_RIGHT);
		txtDomicilio = new TextField();
		txtDomicilio.setPromptText("Calle, No. exterior, Colonia, Localidad");
		txtDomicilio.setMinWidth(400);
		hbDomicilio.getChildren().addAll(etiDomicilio, txtDomicilio);
		
		//Propietario
		hbPropietario = new HBox();
		hbPropietario.setPadding(new Insets(5));
		hbPropietario.setSpacing(5);
		etiPropietario = new Label("Propietario: ");
		etiPropietario.setMinWidth(80);
		etiPropietario.setMinHeight(25);
		etiPropietario.setAlignment(Pos.CENTER_RIGHT);
		txtPropietario = new TextField();
		txtPropietario.setMinWidth(200);
		txtPropietario.setPromptText("Nombre del Propietario");
		hbPropietario.getChildren().addAll(etiPropietario, txtPropietario);
		
		//RFC
		hbRFC = new HBox();
		hbRFC.setPadding(new Insets(5));
		hbRFC.setSpacing(5);
		etiRFC = new Label("RFC: ");
		etiRFC.setMinWidth(80);
		etiRFC.setMinHeight(25);
		etiRFC.setAlignment(Pos.CENTER_RIGHT);
		txtRFC = new TextField();
		txtRFC.setPromptText("Registro Federal de Causantes del Propietario");
		txtRFC.setMinWidth(100);
		hbRFC.getChildren().addAll(etiRFC, txtRFC);
		
		contenidoDatos.getChildren().addAll(hbNombre, hbDomicilio, hbPropietario, hbRFC, hbApertura, hbCierre, hbNoCajones, hbBotones);
	}
}
