/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foromasgraficastecnologias;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author thank
 */
public class ForomasGraficasTecnologias extends Application {
    private ArrayList<Ellipse> listaElipses;
    @Override
    public void start(Stage primaryStage) {
       /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
        Pane root = new Pane();
        
        Scene scene = new Scene(root, 800, 600);
        root.setOnMouseClicked(event -> {
             double r=0.0 ,v=1.0 ,a=0.0;
       
            double x, y , w, h;
            x =  event.getX();
            y =  event.getY();
            w =  Math.random()*150;
            h =  Math.random()*150;
            
            Ellipse elipse1 = new Ellipse();
            elipse1.setCenterX(x);
            elipse1.setCenterY(y);
            elipse1.setRadiusX(w);
            elipse1.setRadiusY(h);
           /* x =  Math.random()*800;
            y =  Math.random()*600;
            w =  Math.random()*50;
            h =  Math.random()*50;
            Rectangle  elipse1 = new Rectangle();
            elipse1.setX(x);
            elipse1.setY(y);
            elipse1.setWidth(w);
            elipse1.setHeight(h);*/
            
            r= Math.random();
            v= Math.random();
            a= Math.random();
            double alpha = Math.random();
            Color color = Color.color(r, v, a, alpha);
           /* v -= avance;
            a += avance;*/
            
            elipse1.setFill(color);
            elipse1.setStroke(color.darker());
            elipse1.setStrokeWidth(4);
            elipse1.getStrokeDashArray().addAll(5d, 5d, 1d, 5d);
            root.getChildren().addAll(elipse1);
    
    
    
    
    }
        );
        
        
        
        
        
        
        
        
       /* double r=0.0 ,v=1.0 ,a=0.0;
        double avance = 1.0/50.0;
        for(int i=0; i<1000; i++){
            double x, y , w, h;*/
            /*x =  Math.random()*800;
            y =  Math.random()*600;
            w =  Math.random()*50;
            h =  Math.random()*50;
            Ellipse elipse1 = new Ellipse();
            elipse1.setCenterX(x);
            elipse1.setCenterY(y);
            elipse1.setRadiusX(w);
            elipse1.setRadiusY(h);*/
           /* x =  Math.random()*800;
            y =  Math.random()*600;
            w =  Math.random()*50;
            h =  Math.random()*50;
            Rectangle  elipse1 = new Rectangle();
            elipse1.setX(x);
            elipse1.setY(y);
            elipse1.setWidth(w);
            elipse1.setHeight(h);
            
            r= Math.random();
            v= Math.random();
            a= Math.random();
            double alpha = Math.random();
            Color color = Color.color(r, v, a, alpha);*/
           /* v -= avance;
            a += avance;*/
            
            /*elipse1.setFill(color);
            elipse1.setStroke(color.darker());
            elipse1.setStrokeWidth(4);
            elipse1.getStrokeDashArray().addAll(5d, 5d, 1d, 5d);
            root.getChildren().addAll(elipse1);
        }/**/
       
        /*Ellipse elipse2 = new Ellipse();
        elipse2.setCenterX(200);
        elipse2.setCenterY(200);
        elipse2.setRadiusX(150);
        elipse2.setRadiusY(70);
        elipse2.setFill(Color.color(0.5, 1.0, 0.0, 0.5));        */
        
        
        
        primaryStage.setTitle("Formas graficas FEI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
