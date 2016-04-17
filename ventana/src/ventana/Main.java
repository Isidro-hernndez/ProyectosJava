package ventana;

import javafx.scene.control.Menu;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author Gaia
 */
public class Main extends Application {
	private static final Pos RIGHT = null;
	@Override
	public void start(Stage ventana) {
		try {
			BorderPane root=new BorderPane();
			Scene scene = new Scene(root,800,400);//raiz,ancho,alto
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    ventana.setScene(scene);
		    crearMenu(root);
			ventana.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void crearMenu(BorderPane contenedor){
		MenuBar barraMenus=new MenuBar();
		Menu menuSistema=new Menu("Sistema");
		Menu menuRegistro=new Menu("Registro");
		MenuItem opcionSalir=new MenuItem("Salir");
		opcionSalir.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		opcionSalir.setGraphic(new ImageView(new File("iconos/salir.png").toURI().toString()));
		opcionSalir.setOnAction((e)->{
			System.exit(0);
		});
                
                
	
		MenuItem opcionRegistroEstacionamiento= new MenuItem("Estacionamiento");
		opcionRegistroEstacionamiento.setGraphic(new ImageView(new File("iconos/estacionamiento.png").toURI().toString()));
		 opcionRegistroEstacionamiento.setOnAction((e) ->{
			crearVentanaDatosEstacionamiento();
		 });
			
				/*BorderPane root2= new BorderPane();
				Stage ventana2= new Stage();
				Scene scene = new Scene(root2,800,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				 VBox contenedorInferior = new VBox();
				
				 Button botonsalir;
				 botonsalir=new Button("Salir");
				 botonsalir.setOnAction((a)->{
						System.exit(0);
					});
				 HBox linea= new HBox();
			        linea.setSpacing(20);
			        linea.setPadding(new Insets(20));
			        Label etiquetanombre = new Label("ESTACIONAMIENTO FEI");
			        etiquetanombre.setAlignment(Pos.TOP_CENTER);
			        
			      
				 
				 HBox linea1= new HBox();
			        linea1.setSpacing(10);
			        linea1.setPadding(new Insets(10));
			        Label etiquetaLugar = new Label("RFC:  ");
			        etiquetaLugar.setAlignment(Pos.CENTER_RIGHT);
			        TextField txtLugar = new TextField();
			        
			        HBox linea2= new HBox();
			        linea2.setSpacing(10);
			        linea2.setPadding(new Insets(10));
			        Label etiquetapropietario= new Label("Nombre del Propietario:  ");
			        etiquetapropietario.setAlignment(Pos.CENTER_RIGHT);
			        TextField txtpropietario = new TextField();
			        
			        HBox linea3= new HBox();
			        linea2.setSpacing(10);
			        linea2.setPadding(new Insets(10));
			        Label etiquetadomicilio= new Label("Domicilio:  ");
			        etiquetadomicilio.setAlignment(Pos.CENTER_RIGHT);
			        TextField txtdomicilio = new TextField();
			        
			        HBox linea4=new HBox();
					Label etiquetahora=new Label("Hora Apertura");
					linea4.setSpacing(10);
					linea4.setPadding(new Insets(10));
					etiquetahora.setAlignment(Pos.CENTER_RIGHT);
					
				     HBox linea5=new HBox();
						Label etiquetahorasalida=new Label("Hora Cierre");
						linea4.setSpacing(10);
						linea4.setPadding(new Insets(10));
						etiquetahorasalida.setAlignment(Pos.CENTER_RIGHT);
			          
						   HBox linea6=new HBox();
							Label etiquetacajones=new Label("Numero de cajon");
							linea6.setSpacing(10);
							linea6.setPadding(new Insets(10));
							etiquetacajones.setAlignment(Pos.CENTER_RIGHT);
							
						 HBox linea7=new HBox();
								Label etiquetaempleado=new Label("Numero de empleado");
								linea6.setSpacing(10);
								linea6.setPadding(new Insets(10));
								etiquetaempleado.setAlignment(Pos.CENTER_RIGHT);
				        
						 HBox linea8=new HBox();
									Label etiquetaservicio=new Label("Servicio");
									linea8.setSpacing(10);
									linea8.setPadding(new Insets(10));
									etiquetaempleado.setAlignment(Pos.CENTER_RIGHT);
									
			        linea.getChildren().addAll(etiquetanombre);
			        linea1.getChildren().addAll(etiquetaLugar, txtLugar);
			        linea2.getChildren().addAll(etiquetapropietario, txtpropietario);
			        linea3.getChildren().addAll(etiquetadomicilio, txtdomicilio);
			        linea4.getChildren().addAll(etiquetahora);
			        linea5.getChildren().addAll(etiquetahorasalida);
			        linea6.getChildren().addAll(etiquetacajones);
			        linea7.getChildren().addAll(etiquetaempleado);
			        linea8.getChildren().addAll(etiquetaservicio);
			        contenedorInferior.getChildren().addAll(linea,linea1,botonsalir,linea2,linea3,linea4,linea5,linea6,linea7,linea8);
			        root2.setLeft(botonsalir);
			        root2.setBottom(contenedorInferior);
			       
		
			        
			        ventana2.setScene(scene);
			        ventana2.setTitle("Estacionamiento");
			        ventana2.show();*/
					
		
		
		MenuItem opcionRegistroEmpleados= new MenuItem("Empleados");
		opcionRegistroEmpleados.setGraphic(new ImageView(new File("iconos/empleado.png").toURI().toString()));
		
		MenuItem opcionRegistroCajones= new MenuItem("Cajones");
		opcionRegistroCajones.setGraphic(new ImageView(new File("iconos/cajon.png").toURI().toString()));
		
		MenuItem opcionRegistroServicios= new MenuItem("Servicios");
		opcionRegistroServicios.setGraphic(new ImageView(new File("iconos/servicio.png").toURI().toString()));
		
		menuSistema.getItems().add(opcionSalir);//se manda a llamar la barra de menus
		menuRegistro.getItems().addAll(opcionRegistroEmpleados,
				new SeparatorMenuItem(), 
				opcionRegistroCajones,
				new SeparatorMenuItem(), opcionRegistroServicios,new SeparatorMenuItem(), opcionRegistroEstacionamiento); 
		
		barraMenus.getMenus().addAll(menuSistema,menuRegistro);
		
		ToolBar barraHerramientas=new ToolBar();
		Button botonSalir=new Button();
		botonSalir.setGraphic(new ImageView(new File("iconos/salir.png").toURI().toString()));
		botonSalir.setTooltip(new Tooltip("Salir de la aplicacion"));
		
		 Button botonEstacionamiento=new Button();
		 botonEstacionamiento.setTooltip(new Tooltip("Editar los datos del Estacionamiento"));
		 botonEstacionamiento.setGraphic(new ImageView(new File("iconos/estacionamiento.png").toURI().toString()));
		
		 
		 Button botonEmpleados=new Button();
		botonEmpleados.setGraphic(new ImageView(new File("iconos/empleado.png").toURI().toString()));
		botonEmpleados.setTooltip(new Tooltip("Registro de los empleaos del estacionamiento"));
		
		Button botonCajones=new Button();
		botonCajones.setGraphic(new ImageView(new File("iconos/cajon.png").toURI().toString()));
		botonCajones.setTooltip(new Tooltip("Edicion de los cajones del estacionamiento"));
		
		Button botonServicios=new Button();
		botonServicios.setGraphic(new ImageView(new File("iconos/servicio.png").toURI().toString()));
		botonServicios.setTooltip(new Tooltip("Registro de servicios"));
		barraHerramientas.getItems().addAll(botonSalir,botonEstacionamiento,botonEmpleados,botonCajones,botonServicios);
			
		VBox cajaSuperior = new VBox();
		cajaSuperior.getChildren().addAll(barraMenus,barraHerramientas);
			
			
			contenedor.setTop(cajaSuperior);
		}
	private void crearVentanaDatosEstacionamiento(){
		ventanaDatosEstacionamiento ventanaEstacionamiento=new ventanaDatosEstacionamiento();
		ventanaEstacionamiento.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}