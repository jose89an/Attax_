//Se importa lo necesario
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * <p>Clase que gestiona las acciones del rat�n cuando se est� jugando en PanelTablero</p>
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
    * @param panelGrafico PanelTablero - Panel en el que acciona el rat�n
    */
   public GestorRaton(PanelTablero panelGrafico){
       this.panelGrafico=panelGrafico;
   }//Fin del constructor
   
   //METODOS
   
   /**
    * <p>M�todo que gestiona el evento de hacer click</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseClicked(MouseEvent evento){
   }//Fin del m�todo mouseClicked
   
   /**
    * <p>M�todo que gestiona el evento de que entre el rat�n en el panel</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseEntered(MouseEvent evento){
   }//Fin del m�todo mouseEntered
   
   /**
    * <p>M�todo que gestiona el evento de que el rat�n salga del panel</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mouseExited(MouseEvent evento){
   }//Fin del m�todo mouseExited
   
   /**
    * <p>M�todo que gestiona el evento de presionar con el rat�n</p>
    * @param evento MouseEvent - Evento gestionado
    */
   public void mousePressed(MouseEvent evento){
       int fila=evento.getX()/PanelTablero.dimensionCasilla;
       int columna=evento.getY()/PanelTablero.dimensionCasilla;
       if(fila>=0 && columna >=0 && fila<=6 && columna <=6){
            xi=fila;
            yi=columna;
       }//Fin de la condici�n de que el rat�n est� dentro de los l�mites del tablero
   }//Fin del m�todo mousePressed
   
   /**
    * <p>M�todo que gestiona el evento de soltar el rat�n</p>
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
       }//Fin de la condici�n de que el rat�n est� dentro de los l�mites del tablero
   }//Fin del m�todo mouseReleased

}//Fin de la clase GestorRaton
