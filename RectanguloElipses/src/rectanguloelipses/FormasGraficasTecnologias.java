package rectanguloelipses;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FormasGraficasTecnologias extends Application {
    private ArrayList<Rectangle> listaElipses; 
    private boolean moverElipses = false;
    private Rectangle elipseSeleccionada=null;
    private Point2D puntoAnterior=null;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Mover");
        btn.setOnAction(event-> {
                moverElipses = !moverElipses;
                if (moverElipses)
                    btn.setText("Dibujar");
                else
                    btn.setText("Mover");
        });
        listaElipses = new ArrayList();
        Pane root = new Pane();
        
        root.setOnMousePressed(event -> {
            if (moverElipses) {
                Point2D punto = new Point2D((double)event.getX(), (double)event.getY());
                for(int i=listaElipses.size()-1; i>=0; i--){
                        Rectangle elipse = listaElipses.get(i);
                if(elipse.contains(punto)){
                    elipseSeleccionada= elipse;
                        puntoAnterior = punto; 
                        break;
                    }
                }
            }
        });
        
        root.setOnMouseReleased(event -> 
            {
              if(moverElipses)
                   elipseSeleccionada = null;
             }
        );
                
        root.setOnMouseDragged(event -> {
            if (moverElipses) {
                if (elipseSeleccionada != null) {
                    double difX = event.getX() - puntoAnterior.getX();
                    double difY = event.getY()- puntoAnterior.getY();
                    elipseSeleccionada.setX(elipseSeleccionada.getX()+difX);
                    elipseSeleccionada.setY(elipseSeleccionada.getY()+difY);
                    puntoAnterior = new Point2D(event.getX(), event.getY());
                }
            }
        });
        
        root.setOnMouseClicked(event -> {
            if (!moverElipses) {
                double r=0.0, v=1.0, a=0;        
                double x, y, w, h;
                x = event.getX();
                y = event.getY();
                w = Math.random()*150;
                h = Math.random()*150;
                Rectangle elipse1 = new Rectangle();
                elipse1.setX(x);
                elipse1.setY(y);
                elipse1.setWidth(w);
                elipse1.setHeight(h);
            
                r = Math.random();
                v = Math.random();
                a = Math.random();
                double alpha = Math.random();
                Color color = Color.color(r, v, a, alpha);
            //v -= avance;
            //a += avance;
                elipse1.setFill(color);
                elipse1.setStroke(color.darker());
                elipse1.setStrokeWidth(1);
                elipse1.getStrokeDashArray().addAll(5d,5d,1d,5d);
                root.getChildren().addAll(elipse1);        
                listaElipses.add(elipse1);
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
