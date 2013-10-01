//Se import lo necesario
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * <p>Clase que gestiona el men� que usar� el jFrame, implementa la interfaz ActionListener</p>
 * @author Jose y Alberto
 */
public class GestorMenu implements ActionListener{
    private TableroGrafico tableroControlado;
    
    /**
     * <p>Constructor de GestorMenu con un argumento
     * @param tableroControlado TableroGrafico - jFrame sobre el que act�a la clase
     */
    public GestorMenu(TableroGrafico tableroControlado){
        this.tableroControlado=tableroControlado;
    }//Fin del constructor
    
    /**
     * <p>M�todo que controla las acciones hechas en el men�</p>
     * @param e ActionEvent - Evento accionado
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tableroControlado.devolverMenuvolver())){
            tableroControlado.getContentPane().removeAll();
            tableroControlado.getContentPane().add(tableroControlado.devolverMenup());
            tableroControlado.pack();
            tableroControlado.devolverMenup().updateUI();
        }//Fin de la condici�n del men� Volver
        if(e.getSource().equals(tableroControlado.devolverMenuguardar())){
            if(tableroControlado.devolverPanelt().devolverMulti()==false){
                TableroLogico t=tableroControlado.devolverPanelt().devolverTablero();
                tableroControlado.devolverColectortableros().insertarTablero(t.devolverNick(),t);
                tableroControlado.devolverColectortableros().almacenarTableros();
                JOptionPane.showMessageDialog(tableroControlado, "Tablero guardado con �xito para el jugador "+t.devolverNick());
            }//Fin del caso para el que se juega en modo de un jugador
        }//Fin de la condici�n del men� Guardar
        if (e.getSource().equals(tableroControlado.devolverMenureiniciar())){
            tableroControlado.reiniciar();
        }//Fin de la condici�n del men� Reiniciar
        if (e.getSource().equals(tableroControlado.devolverMenusalir())){
            System.exit(0);
        }//Fin de la condici�n del men� Salir
    }//Fin del m�todo actionPerformed
}//Fin de la clase GestorMenu
