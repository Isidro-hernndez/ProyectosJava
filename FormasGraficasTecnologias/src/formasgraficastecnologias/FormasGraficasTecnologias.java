package formasgraficastecnologias;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class FormasGraficasTecnologias extends Application {
    private ArrayList<Shape> listaFormas; 
    private boolean moverFormas = false;
    private Shape formaSeleccionada=null;
    private Point2D puntoAnterior=null;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Mover");
        btn.setOnAction(event-> {
                moverFormas = !moverFormas;
                if (moverFormas)
                    btn.setText("Dibujar");
                else
                    btn.setText("Mover");
        });
        listaFormas = new ArrayList();
        Pane root = new Pane();
        
        
        root.setOnMousePressed(event -> {
            if (moverFormas) {
                Point2D punto = new Point2D((double)event.getX(), (double)event.getY());
                for(int i=listaFormas.size()-1; i>=0; i--){
                    Shape forma = listaFormas.get(i);
                    if(forma.contains(punto)){
                        formaSeleccionada= forma;
                        puntoAnterior = punto; 
                        break;
                    }
                }
            }
        });
        
        root.setOnMouseReleased(event -> 
            {
              if(moverFormas)
                   formaSeleccionada = null;
             }
        );
                
        root.setOnMouseDragged(event -> {
            if (moverFormas) {
                if (formaSeleccionada != null) {
                    double difX = event.getX() - puntoAnterior.getX();
                    double difY = event.getY()- puntoAnterior.getY();
                    if(formaSeleccionada.getClass().equals(Ellipse.class)){
                        Ellipse elipse = (Ellipse) formaSeleccionada;
                        elipse.setCenterX(elipse.getCenterX()+difX);
                        elipse.setCenterY(elipse.getCenterY()+difY);
                    }else if(formaSeleccionada.getClass().equals(Rectangle.class)){
                        Rectangle rect = (Rectangle) formaSeleccionada;
                        rect.setX(rect.getX()+difX);
                        rect.setY(rect.getY()+difY);
                    }
                    
                    puntoAnterior = new Point2D(event.getX(), event.getY());
                }
            }
        });
        
        root.setOnMouseClicked(event -> {
            if (!moverFormas) {
                double r=0.0, v=1.0, a=0;        
                double x, y, w, h;
                Shape forma=null;
                x = event.getX();
                y = event.getY();
                w = Math.random()*150;
                h = Math.random()*150;
                
                int tipo = (int)( Math.random()*2);
                if(tipo == 0){
                    
                    Ellipse elipse = new Ellipse();
                    elipse.setCenterX(x);
                    elipse.setCenterY(y);
                    elipse.setRadiusX(w);
                    elipse.setRadiusY(h);
                    forma = elipse;
                }
                else if(tipo == 1){
                    Rectangle rect = new Rectangle();
                    rect.setX(x);
                    rect.setY(y);
                    rect.setWidth(w);
                    rect.setHeight(h);
                    forma = rect;
                }
            
                r = Math.random();
                v = Math.random();
                a = Math.random();
                double alpha = Math.random();
                Color color = Color.color(r, v, a, alpha);
            //v -= avance;
            //a += avance;
                forma.setFill(color);
                forma.setStroke(color.darker());
                forma.setStrokeWidth(1);
                forma.getStrokeDashArray().addAll(5d,5d,1d,5d);
                root.getChildren().addAll(forma);        
                listaFormas.add(forma);
            }
        });
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Formas Gráficas FEI");
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
