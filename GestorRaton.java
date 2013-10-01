//Se importa lo necesario
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * <p>Clase que gestiona las acciones del ratón cuando se está jugando en PanelTablero</p>
 * @author Jose y Alberto
 */
public class GestorRaton implements MouseListener{
    private  PanelTablero panelGrafico;
    private int xi;
    private int xf;
    private int yi;
    private int yf;
    
   /**
    * <p>Constructor de GestorRaton con un argumento</p>
    * @param panelGrafico PanelTablero - Panel en el que acciona el ratón
    */
   public GestorRaton(PanelTablero panelGrafico){
       this.panelGrafico=panelGrafico;
   }//Fin del constructor
   
   //METODOS
   
   /**
    * <p>Método que gestiona el evento de hacer click</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseClicked(MouseEvent evento){
   }//Fin del método mouseClicked
   
   /**
    * <p>Método que gestiona el evento de que entre el ratón en el panel</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseEntered(MouseEvent evento){
   }//Fin del método mouseEntered
   
   /**
    * <p>Método que gestiona el evento de que el ratón salga del panel</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseExited(MouseEvent evento){
   }//Fin del método mouseExited
   
   /**
    * <p>Método que gestiona el evento de presionar con el ratón</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mousePressed(MouseEvent evento){
       int fila=evento.getX()/PanelTablero.dimensionCasilla;
       int columna=evento.getY()/PanelTablero.dimensionCasilla;
       if(fila>=0 && columna >=0 && fila<=6 && columna <=6){
            xi=fila;
            yi=columna;
       }//Fin de la condición de que el ratón esté dentro de los límites del tablero
   }//Fin del método mousePressed
   
   /**
    * <p>Método que gestiona el evento de soltar el ratón</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseReleased(MouseEvent evento){
       int fila=evento.getX()/PanelTablero.dimensionCasilla;
       int columna=evento.getY()/PanelTablero.dimensionCasilla;
       if(fila>=0 && columna >=0 && fila<=6 && columna <=6){
            xf=fila;
            yf=columna;
            panelGrafico.movimiento(xi,yi,xf,yf,panelGrafico.devolverMulti());
            panelGrafico.repaint();
       }//Fin de la condición de que el ratón esté dentro de los límites del tablero
   }//Fin del método mouseReleased

}//Fin de la clase GestorRaton
