/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Gaia
 */
public class ventanaDatosEstacionamiento extends Stage{
	private VBox contenidoDatos;
	private BorderPane contenidoEmpleados;
	
	public ventanaDatosEstacionamiento(){
	TabPane tabs=new TabPane();
	Tab tabDatos=new Tab("datos generales");
	Tab tabEmpleados=new Tab("empleados");
	tabs.getTabs().addAll(tabDatos,tabEmpleados);
	
	contenidoDatos=new VBox();
	contenidoEmpleados=new BorderPane();
	tabDatos.setContent(contenidoDatos);
	tabEmpleados.setContent(contenidoEmpleados);
	

	Scene escenaEstacionamiento=new Scene(tabs,500,400);
	this.setScene(escenaEstacionamiento);
	this.setTitle("captura de estacionamiento");
		
	crearComponentesDatos();
        crearContenidoEmpleados();

}
        
        private void crearContenidoEmpleados(){
           
            //aqui se inserta el codigo para la ventana
          // contenidoEmpleados.getChildren().addAll(hbNombre,hbDomicilio,hbPropietario,hbRFC,hbApertura,hbCierre,hbNocajones,hbBotones);
            
            
        }
	private void crearComponentesDatos(){
		
		HBox hbNombre,hbDomicilio,hbPropietario,hbRFC,hbApertura,hbCierre,hbNocajones,hbBotones;
		Label etiNombre,etiDomicilio,etiPropietario,etiRFC,etiApertura,etiCierre,etiNocajones;
		TextField txtNombre,txtDomicilio,txtPropietario,txtRFC,txtNocajones;
		Slider hsApertura,hsCierre;
		Button botonAceptar,botonCancelar; 
		
		//hora de apertura
		hbApertura=new HBox();
		hbApertura.setPadding(new Insets(5));
		hbApertura.setSpacing(5);
		etiApertura=new Label("Hora Apertura:");
		etiApertura.setMinWidth(80);
		etiApertura.setMinHeight(25);
		etiApertura.setAlignment(Pos.CENTER_RIGHT);
		hsApertura=new Slider();
		hsApertura.setOrientation(Orientation.HORIZONTAL);
		hsApertura.setMinWidth(400);
		hsApertura.setMin(0);
		hsApertura.setMax(24);
		hsApertura.setValue(7);
		hsApertura.setMajorTickUnit(1);
		hsApertura.setMinorTickCount(0);
		hsApertura.setShowTickLabels(true);
		hsApertura.setShowTickMarks(true);
		hbApertura.getChildren().addAll(etiApertura,hsApertura);
		
		//hora de cierre
		hbCierre=new HBox();
		hbCierre.setPadding(new Insets(5));
		hbCierre.setSpacing(5);
		etiCierre=new Label("Hora de Cierre:");
		etiCierre.setMinWidth(80);
		etiCierre.setMinHeight(25);
		etiCierre.setAlignment(Pos.CENTER_RIGHT);
		hsCierre=new Slider();
		hsCierre.setOrientation(Orientation.HORIZONTAL);
		hsCierre.setMinWidth(400);
		hsCierre.setMin(0);
		hsCierre.setMax(24);
		hsCierre.setValue(7);
		hsCierre.setMajorTickUnit(1);
		hsCierre.setMinorTickCount(0);
		hsCierre.setShowTickLabels(true);
		hsCierre.setShowTickMarks(true);
		hbCierre.getChildren().addAll(etiCierre,hsCierre);
		
		//cajones
		hbNocajones=new HBox();
		hbNocajones.setPadding(new Insets(5));
		hbNocajones.setSpacing(5);
		etiNocajones=new Label("Numero de Cajon");
		etiNocajones.setMinWidth(80);
		etiNocajones.setMinHeight(25);
		etiNocajones.setAlignment(Pos.CENTER_RIGHT);
		txtNocajones=new TextField();
		txtNocajones.setPromptText("numero del cajon ");
		txtNocajones.setMinWidth(20);
		hbNocajones.getChildren().addAll(etiNocajones,txtNocajones);
		
		//Botones
		hbBotones=new HBox();
		hbBotones.setAlignment(Pos.CENTER_RIGHT);
		hbBotones.setPadding(new Insets(5));
		hbBotones.setSpacing(5);
		botonAceptar=new Button("Aceptar");
		botonCancelar=new Button("Cancelar");
		hbBotones.getChildren().addAll(botonAceptar,botonCancelar);
		
		//nombre del estacionamiento
		hbNombre=new HBox();
		hbNombre.setPadding(new Insets(5));
		hbNombre.setSpacing(5);
		etiNombre=new Label("Nombre");
		etiNombre.setMinWidth(80);
		etiNombre.setMinHeight(25);
		etiNombre.setAlignment(Pos.CENTER_RIGHT);
		txtNombre=new TextField();
		txtNombre.setPromptText("Nombre del estacionamiento");
		txtNombre.setMinWidth(20);
		hbNombre.getChildren().addAll(etiNombre,txtNombre);
		
		//domicilio
		hbDomicilio=new HBox();
		hbDomicilio.setPadding(new Insets(5));
		hbDomicilio.setSpacing(5);
		etiDomicilio=new Label("Domicilio");
		etiDomicilio.setMinWidth(80);
		etiDomicilio.setMinHeight(25);
		etiDomicilio.setAlignment(Pos.CENTER_RIGHT);
		txtDomicilio=new TextField();
		txtDomicilio.setPromptText("Calle,No,colonia");
		txtDomicilio.setMinWidth(20);
		hbDomicilio.getChildren().addAll(etiDomicilio,txtDomicilio);
		
		//propietario
		hbPropietario=new HBox();
		hbPropietario.setPadding(new Insets(5));
		hbPropietario.setSpacing(5);
		etiPropietario=new Label("Nombre del propietario");
		etiPropietario.setMinWidth(80);
		etiPropietario.setMinHeight(25);
		etiPropietario.setAlignment(Pos.CENTER_RIGHT);
		txtPropietario=new TextField();
		txtPropietario.setPromptText("Nombre,ApellidoPaterno,Apellido Materno");
		txtPropietario.setMinWidth(20);
		hbPropietario.getChildren().addAll(etiPropietario,txtPropietario);
		
		//RFC
		hbRFC=new HBox();
		hbRFC.setPadding(new Insets(5));
		hbRFC.setSpacing(5);
		etiRFC=new Label("Registro Federal de Causantes del Propietario");
		etiRFC.setMinWidth(80);
		etiRFC.setMinHeight(25);
		etiRFC.setAlignment(Pos.CENTER_RIGHT);
		txtRFC=new TextField();
		txtRFC.setPromptText("RFC");
		txtRFC.setMinWidth(20);
		hbRFC.getChildren().addAll(etiRFC,txtRFC);
		
		
		
		
		contenidoDatos.getChildren().addAll(hbNombre,hbDomicilio,hbPropietario,hbRFC,hbApertura,hbCierre,hbNocajones,hbBotones);
		
		
	}
	
}