package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage ventana) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ventana.setScene(scene);
			crearMenu(root);
			ventana.show();
			ventana.setTitle("Control del Estacionamiento de la FEI");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void crearMenu(BorderPane contenedor) {
		MenuBar barraMenus = new MenuBar();
		Menu menuSistema = new Menu("Sistema");
		Menu menuRegistro = new Menu("Registro");
		MenuItem opcionSalir = new MenuItem("Salir");		
		opcionSalir.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
		opcionSalir.setGraphic(new ImageView(new File("iconos/salir.png").toURI().toString()));		
		opcionSalir.setOnAction((evento) ->  {
			System.exit(0);
		});
		
		MenuItem opcionRegistroEstacionamiento = new MenuItem("Estacionamiento");		
		opcionRegistroEstacionamiento.setOnAction((evento) -> {
			crearVentanaEstacionamiento();
		});
		
		MenuItem opcionRegistroEmpleados = new MenuItem("Empleados");
		opcionRegistroEmpleados.setGraphic(new ImageView(new File("iconos/empleado.png").toURI().toString()));		
		MenuItem opcionRegistroCajones = new MenuItem("Cajones");
		opcionRegistroCajones.setGraphic(new ImageView(new File("iconos/cajon.png").toURI().toString()));		
		MenuItem opcionRegistroServicios = new MenuItem("Servicios");
		opcionRegistroServicios.setGraphic(new ImageView(new File("iconos/servicio.png").toURI().toString()));		
		
		menuSistema.getItems().add(opcionSalir);
		menuRegistro.getItems().addAll(
				opcionRegistroEstacionamiento,
				opcionRegistroEmpleados,
				new SeparatorMenuItem(),
				opcionRegistroCajones,
				new SeparatorMenuItem(),
				opcionRegistroServicios);
		barraMenus.getMenus().addAll(menuSistema, menuRegistro);
		
		ToolBar barraHerramientas = new ToolBar();
		
		Button botonSalir = new Button();
		botonSalir.setGraphic(new ImageView(new File("iconos/salir.png").toURI().toString()));
		botonSalir.setTooltip(new Tooltip("Salir de la aplicación"));
		botonSalir.setOnAction((e) -> {System.exit(0);});
		Button botonEstacionamiento = new Button();		
		botonEstacionamiento.setTooltip(new Tooltip("Editar los datos del Estacionamiento"));
		botonEstacionamiento.setOnAction((evento) -> {
			crearVentanaEstacionamiento();
		});
		Button botonEmpleados = new Button();
		botonEmpleados.setGraphic(new ImageView(new File("iconos/empleado.png").toURI().toString()));
		botonEmpleados.setTooltip(new Tooltip("Registro de los Empleados del Estacionamiento"));
		Button botonCajones = new Button();
		botonCajones.setGraphic(new ImageView(new File("iconos/cajon.png").toURI().toString()));
		botonCajones.setTooltip(new Tooltip("Edición de los Cajones del Estacionamiento"));
		Button botonServicios = new Button();
		botonServicios.setGraphic(new ImageView(new File("iconos/servicio.png").toURI().toString()));
		botonServicios.setTooltip(new Tooltip("Registro de servicios"));
		barraHerramientas.getItems().addAll(botonSalir,
																   botonEstacionamiento,
																   botonEmpleados, 
																   botonCajones,
																   botonServicios);
		
		VBox cajaSuperior = new VBox();		
		cajaSuperior.getChildren().addAll(barraMenus, barraHerramientas);
		
		contenedor.setTop(cajaSuperior);
	}
	
	private void crearVentanaEstacionamiento() {
		VentanaDatosEstacionamiento ventanaEstacionamiento = new VentanaDatosEstacionamiento();
		ventanaEstacionamiento.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
