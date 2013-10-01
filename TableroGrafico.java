//Se importa lo necesario
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * <p>Clase que sirve de jFrame para que arranque el programa</p>
 * @author  Jose y Alberto
 */
public class TableroGrafico extends javax.swing.JFrame {
    final static int  Horizontal=10;
    final static int Vertical=30;
    private PanelTablero panelt;
    private MenuPrincipal menup;
    private MenuJugador menuj;
    private MenuJugador2 menuj2;
    private MenuNuevoUsuario menunu;
    private MenuEstadisticas menues;
    private MenuMultijugador menumulti;
    private MenuItem menureiniciar;
    private MenuItem menuguardar;
    private MenuItem menusalir;
    private MenuItem menuvolver;
    private ColectorJugador colectorjugador;
    private ColectorTableros colectortableros;
    
    /**
     * <p>Constructor sin argumentos de TableroGrafico</p>
     */
    public TableroGrafico(){
        panelt=new PanelTablero(7,7,new TableroLogico(),this,true,new Jugador(),new Jugador());
        menunu=new MenuNuevoUsuario(this);
        menuj=new MenuJugador(this);
        menuj2=new MenuJugador2(this);
        menues=new MenuEstadisticas(this,new Jugador());
        menumulti=new MenuMultijugador(this);
        colectorjugador=new ColectorJugador();
        colectortableros=new ColectorTableros();
        //Estos son jugadores que se añaden por defecto al disco duro para la ejecución del programa
        //colectorjugador.nuevoJugador("default",new Jugador("default","default","Sin nombre","Sin apellido","Sin DNI","Sin e-mail"));
        //colectortableros.insertarTablero("default",new TableroLogico());
        //colectorjugador.almacenarJugadores();
        //colectortableros.almacenarTableros();
        //Una vez creados, pueden obviarse las 4 sentencias entre los comentarios
        colectorjugador.leerJugadores();
        colectortableros.leerTableros();
        menup=new MenuPrincipal(this);
        getContentPane().add(menup);
        setBackground(Color.GRAY);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } //Fin del constructor por defecto de TableroGrafico
    
    /**
     * <p>Método que inicializa los menús del jFrame</p>
     */
    private void inicializaMenus() {
        MenuBar mbarra = new MenuBar();
        Menu m = new Menu("Archivo");
        menureiniciar=new MenuItem("Reiniciar partida");
        menuguardar=new MenuItem("Guardar Partida (1 jugador)");
        menusalir=new MenuItem("Salir");
        menuvolver=new MenuItem("Volver al Menú Principal");
        GestorMenu g=new GestorMenu(this);
        
        menureiniciar.addActionListener(g);
        menuguardar.addActionListener(g);
        menusalir.addActionListener(g);
        menuvolver.addActionListener(g);
        
        m.add(menureiniciar);
        m.add(menuguardar);
        m.add(menuvolver);
        m.addSeparator();
        m.add(menusalir);
        mbarra.add(m);

        setMenuBar(mbarra);
        
        }//Fin del método inicializaMenus
    
    /**
     * <p>Devuelve el PanelTablero asociado al jFrame</p>
     * @return PanelTablero asociado al jFrame
     */
    public PanelTablero devolverPanelt(){
        return panelt;
    }//Fin del método devolverPanelt
    
    /**
     * <p>Devuelve el MenuPrincipal asociado al jFrame</p>
     * @return MenuPrincipal asociado al jFrame
     */
    public MenuPrincipal devolverMenup(){
        return menup;
    }//Fin del método devolverMenup
    
    /**
     * <p>Devuelve el MenuJugador asociado al jFrame</p>
     * @return MenuJugador asociado al jFrame
     */
    public MenuJugador devolverMenuj(){
        return menuj;
    }//Fin del método devolverMenuj
    
    /**
     * <p>Devuelve el MenuJugador2 asociado al jFrame</p>
     * @return MenuJugador2 asociado al jFrame
     */
    public MenuJugador2 devolverMenuj2(){
        return menuj2;
    }//Fin del método devolverMenuj2
    
    /**
     * <p>Devuelve el MenuNuevoUsuario asociado al jFrame</p>
     * @return MenuNuevoUsuario asociado al jFrame
     */
    public MenuNuevoUsuario devolverMenunu(){
        return menunu;
    }//Fin del método devolverMenunu
    
    /**
     * <p>Devuelve el MenuEstadisticas asociado al jFrame</p>
     * @return MenuEstadisticas asociado al jFrame
     */
    public MenuEstadisticas devolverMenues(){
        return menues;
    }//Fin del método devolverMenues
    
    /**
     * <p>Devuelve el MenuMultijugador asociado al jFrame</p>
     * @return MenuMultijugador asociado al jFrame
     */
    public MenuMultijugador devolverMenumulti(){
        return menumulti;
    }//Fin del método devolverMenumulti
    
    /**
     * <p>Devuelve el Menú Reiniciar</p>
     * @return MenuItem Reiniciar
     */
    public MenuItem devolverMenureiniciar(){
        return menureiniciar;
    }//Fin del método devolverMenureiniciar
    
    /**
     * <p>Devuelve el Menú Guardar</p>
     * @return MenuItem Guardar
     */
    public MenuItem devolverMenuguardar(){
        return menuguardar;
    }//Fin del método devolverMenuguardar
    
    /**
     * <p>Devuelve el Menú Salir</p>
     * @return MenuItem Salir
     */
    public MenuItem devolverMenusalir(){
        return menusalir;
    }//Fin del método devolverMenusalir
    
    /**
     * <p>Devuelve el Menú Volver</p>
     * @return MenuItem Volver
     */
    public MenuItem devolverMenuvolver(){
        return menuvolver;
    }//Fin del método devolverMenuvolver
    
    /**
     * <p>Devuelve el colector de jugadores</p>
     * @return ColectorJugador asociado al jFrame
     */
    public ColectorJugador devolverColectorjugador(){
        return colectorjugador;
    }//Fin del método devolverColectorjugador
    
    /**
     * <p>Devuelve el colector de tableros</p>
     * @return ColectorTableros asociado al jFrame
     */
    public ColectorTableros devolverColectortableros(){
        return colectortableros;
    }//Fin del método devolverColectortableros
    
    /**
     * <p>Modifica el PanelTablero asociado al jFrame</p>
     * @param panelt - PanelTablero nuevo
     */
    public void modificarPanelt(PanelTablero panelt){
        this.panelt=panelt;
    }//Fin del método modificarPanelt
    
    /**
     * <p>Modifica el MenuPrincipal asociado al jFrame</p>
     * @param menup - MenuPrincipal nuevo
     */
    public void modificarMenup(MenuPrincipal menup){
        this.menup=menup;
    }//Fin del método modificarMenup
    
    /**
     * <p>Modifica el MenuJugador asociado al jFrame</p>
     * @param menuj - MenuJugador nuevo
     */
    public void modificarMenuj(MenuJugador menuj){
        this.menuj=menuj;
    }//Fin del método modificarMenuj
    
    /**
     * <p>Modifica el MenuJugador2 asociado al jFrame</p>
     * @param menuj2 - MenuJugador2 nuevo
     */
    public void modificarMenuj2(MenuJugador2 menuj2){
        this.menuj2=menuj2;
    }//Fin del método modificarMenuj2
    
    /**
     * <p>Modifica el MenuNuevoUsuario asociado al jFrame</p>
     * @param menunu - MenuNuevoUsuario nuevo
     */
    public void modificarMenunu(MenuNuevoUsuario menunu){
        this.menunu=menunu;
    }//Fin del método modificarMenunu
    
    /**
     * <p>Modifica el MenuEstadisticas asociado al jFrame</p>
     * @param menues - MenuEstadisticas nuevo
     */
    public void modificarMenues(MenuEstadisticas menues){
        this.menues=menues;
    }//Fin del método modificarMenues
    
    /**
     * <p>Modifica el MenuMultijugador asociado al jFrame</p>
     * @param menumulti - MenuMultijugador nuevo
     */
    public void modificarMenumulti(MenuMultijugador menumulti){
        this.menumulti=menumulti;
    }//Fin del método modificarMenumulti
    
    /**
     * <p>Modifica el nick del TableroLogico de PanelTablero</p>
     * @param nick String - Nick nuevo
     */
    public void cambiarNickTL(String nick){
        panelt.devolverTablero().modificarNick(nick);
    }//Fin del método cambiarNickTL
    
    /**
     * <p>Reinicia el tablero si está activo</p>
     */
    public void reiniciar(){
      this.panelt.modificarTablero(new TableroLogico());
      this.panelt.repaint();
  }//Fin del método reiniciar

    //MÉTODO MAIN 
    public static void main(String args[]){
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           TableroGrafico tablero=new TableroGrafico();
           tablero.inicializaMenus();
        }//Fin del método run
    });   

  }//Fin del método main
    
}//Fin de la clase TableroGrafico