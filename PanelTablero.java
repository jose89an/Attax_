//Se importa lo necesario
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * <p>Clase de tipo JPanel que representa el tablero de juego</p>
 * @author Jose y Alberto
 */
public class PanelTablero extends JPanel
{
    
    public final static int dimensionCasilla=50;
    private int filas;
    private int columnas;  
    private boolean multijugador;
    private ArrayList<Line2D.Float> lineasDelimitadoras;
    private Ellipse2D.Float[][] circulos;
    private TableroLogico tablero;
    private TableroGrafico tableroasociado;
    private GestorRaton gestorEventosRaton;
    private Jugador jugador1;
    private Jugador jugador2;
    


    /**
     * <p>Constructor con argumentos de PanelTablero</p>
     * @param filas int
     * @param tablero TableroLogico
     * @param tableroasociado TableroGrafico
     * @param multijugador boolean
     * @param jugador1 Jugador
     * @param jugador2 Jugador
     */
    public PanelTablero(int filas, int columnas,TableroLogico tablero,TableroGrafico tableroasociado,boolean multijugador,Jugador jugador1,Jugador jugador2){
        this.filas=filas;
        this.columnas=columnas;
        this.tablero=tablero;
        this.multijugador=multijugador;
        this.tableroasociado=tableroasociado;
        this.jugador1=jugador1;
        this.jugador2=jugador2;
        lineasDelimitadoras=new ArrayList<Line2D.Float>();
        circulos=new Ellipse2D.Float[7][7];
        Dimension dimension=new Dimension(columnas*dimensionCasilla,filas*dimensionCasilla+20);
        setPreferredSize(dimension);
        crearLineasDelimitadoras();
        repaint();
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                agregarCirculo(i,j); 
            }   
        }
        gestorEventosRaton=new GestorRaton(this);
        addMouseListener(gestorEventosRaton);
    }//Fin del constructor
    
    //MÉTODOS
    
    /**
     * <p>Método que devuelve un tablero</p>
     * @return TableroLogico asociado al jPanel
     */
    public TableroLogico devolverTablero(){
        return tablero;
    }//Fin del método devolverTablero
    
    /**
     * <p>Método que modifica un tablero</p>
     * @param tablero TableroLogico nuevo
     */
    public void modificarTablero(TableroLogico tablero){
        this.tablero=tablero;
    }//Fin del método modificarTablero
    
    /**
     * <p>Método que devuelve el jugador 1</p>
     * @return Jugador 1
     */
    public Jugador devolverJugador1(){
        return jugador1;
    }//Fin del método devolverJugador1
    
    /**
     * <p>Método que devuelve el jugador 2</p>
     * @return Jugador 2
     */
    public Jugador devolverJugador2(){
        return jugador2;
    }//Fin del método devolverJugador2

/**
 * <p>Metodo para agregar un circulo mediante la fila y la columna</p>
 * @param fila int - Fila que ocupa el círculo
 * @param columna int - Columna que ocupa el círculo
 */
public void agregarCirculo(int fila, int columna){
    Ellipse2D.Float circulo;
    int xSupIzq=columna*dimensionCasilla+5;
    int ySupIzq=fila*dimensionCasilla+5;
    circulo=new Ellipse2D.Float(xSupIzq,ySupIzq,dimensionCasilla-10,dimensionCasilla-10);
    circulos[fila][columna]=circulo;
}//Fin del método agregarCirculo

/**
 * <p>Metodo para pintar en el panel</p>
 * @param g Graphics
 */
 public void paint(Graphics g){
    Graphics2D g2=(Graphics2D)g;

    g2.setColor(Color.WHITE);
    // Pintado de lineas delimitadoras
    for(Line2D.Float linea: lineasDelimitadoras){
      g2.draw(linea);
    
    }
 for(int i=0;i<7;i++){
     for(int j=0;j<7;j++){
         int n=tablero.devolverPos(i,j);
         if(n==0){
             g2.setColor(Color.GRAY);
             g2.fill(circulos[j][i]);
         }
         else{ 
             if(n==1){
             g2.setColor(Color.GREEN);
             g2.fill(circulos[j][i]);
                        }
               else {
                 if(n==2){   
             g2.setColor(Color.RED);
             g2.fill(circulos[j][i]);
                          }
                  }
         }
     }
   }  
 }//Fin del método paint
 
  /**
   * <p>Método que crea las líneas delimitadoras</p>
   */
  private void crearLineasDelimitadoras(){
    Line2D.Float linea;
    int xp,yp,xl,yl;
    for(int i=0; i < columnas+1; i++){ 
      xp=i*dimensionCasilla;
      yp=0;
      xl=xp;
      yl=filas*dimensionCasilla;
      linea=new Line2D.Float(xp,yp,xl,yl);
      lineasDelimitadoras.add(linea);
    }
    for(int i=0; i < filas+1; i++){
      xp=0;
      yp=i*dimensionCasilla;
      xl=filas*dimensionCasilla;
      yl=yp;
      linea=new Line2D.Float(xp,yp,xl,yl);
      lineasDelimitadoras.add(linea);
    }
  }//Fin del método crearLineasDelimitadoras
  
  /**
   * <p>Método que comprueba si se está jugando en modo multijugador</p>
   * @return boolean True si es multijugador, False si es un jugador
   */
  public boolean devolverMulti(){
        return multijugador;
    }//Fin del método devolverMulti
    
  /**
   * <p>Método que modifica el modo de juego (multijugador o no)</p>
   * @param multijugador boolean
   */
    public void modificarMulti(boolean multijugador){
        this.multijugador=multijugador;
    }//Fin del método modificarMulti
  
  /**
   * <p>Método que hace la llamada al método mover de TableroLogico en el panel</p>
   * @param xi int - Posición horizontal inicial
   * @param yi int - Posición vertical inicial
   * @param xf int - Posición horizontal final
   * @param yf int - Posición vertical final
   */
  public boolean moverG(int xi,int yi,int xf,int yf){
      tablero.mover(xi,yi,xf,yf);
      comprobar();
      repaint();
      return tablero.duplicar(xi,yi,xf,yf);
  }//Fin del método moverG

  
  /**
   * <p>Método que hace la llamada al método duplicar de TableroLogico en el panel</p>
   * @param xi int - Posición horizontal inicial
   * @param yi int - Posición vertical inicial
   * @param xf int - Posición horizontal final
   * @param yf int - Posición vertical final
   */
  public boolean duplicarG(int xi,int yi,int xf,int yf){
      tablero.duplicar(xi,yi,xf,yf);
      comprobar();
      repaint();
      return tablero.duplicar(xi,yi,xf,yf);
   }//Fin del método duplicarG
  
  /**
   * <p>Método que haya el máximo entre dos números</p>
   * @param x int - Un número
   * @param y int - Otro número
   * @return int El máximo de ambos números
   */
  public int maximo(int x,int y){
    if (x>y){
      return x;
    }//Fin de la condición x>y
    else{
      return y;
    }//Fin de la condición y>x
  }//Fin del método maximo
  
  /**
   * <p>Método que elige el movimiento posible según la posición de origen y destino de la ficha. Distingue entre un jugador y multijugador</p>
   * @param xi int - Posición horizontal inicial
   * @param yi int - Posición vertical inicial
   * @param xf int - Posición horizontal final
   * @param yf int - Posición vertical final
   * @param multi boolean - Booleano que determina si es modo multijugador o no 
   */
  public void movimiento(int xi,int yi,int xf,int yf,boolean multi){
      if (multi){
          if(tablero.devolverPos(xi,yi)==tablero.devolverTurno()){
            if(tablero.devolverPos(xi,yi)!=0){
                if(tablero.devolverPos(xf,yf)==0){
                    if(maximo(Math.abs(xf-xi),Math.abs(yf-yi))==1){
                         duplicarG(xi,yi,xf,yf);
                         if(tablero.devolverTurno()==1){
                             tablero.modificarTurno(2);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador2.devolverNick());
                         }//Fin de la condición de las fichas verdes
                         else if(tablero.devolverTurno()==2){
                             tablero.modificarTurno(1);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador1.devolverNick());
                         }//FIn de la condición de las fichas rojas
                    }//Fin del caso para movimiento de radio 1
                    else if(maximo(Math.abs(xf-xi),Math.abs(yf-yi))==2){
                       moverG(xi,yi,xf,yf);
                       if(tablero.devolverTurno()==1){
                             tablero.modificarTurno(2);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador2.devolverNick());
                         }//Fin de la condición de las fichas verdes
                       else if(tablero.devolverTurno()==2){
                             tablero.modificarTurno(1);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador1.devolverNick());
                         }//Fin de la condición de las fichas rojas
                     }//Fin del caso para movimiento de radio 2
                }//Fin de la comprobación de que la posición final sea un hueco
            }//Fin de la comprobación de que no movamos un hueco
        }//Fin de la comprobación de que estemos en el turno correcto
      }//Fin del modo multijugador
      else{
        if(tablero.devolverPos(xi,yi)==1){
            if(tablero.devolverPos(xi,yi)!=0){
                if(tablero.devolverPos(xf,yf)==0){
                    if(maximo(Math.abs(xf-xi),Math.abs(yf-yi))==1){
                         duplicarG(xi,yi,xf,yf);
                          minimax(0,tablero,true);
                    }//Fin del caso de movimiento de radio 1
                    else if(maximo(Math.abs(xf-xi),Math.abs(yf-yi))==2){
                       moverG(xi,yi,xf,yf);
                        minimax(0,tablero,true);
                     }//Fin del caso de movimiento de radio 2
                }//Fin de la comprobación de que la posición final sea un hueco
            }//Fin de la condición de que no movamos huecos
        }//Fin de la condición de las fichas verdes
      }//Fin del modo de un jugador
  }//Fin del método movimiento

  
  /**
   * <p>Método que comprueba cada turno la situación de la partida y cuándo hay un ganador</p>
   */
  public void comprobar(){
      int fichasverdes=tablero.contarFichasV();
      int fichasrojas=tablero.contarFichasR();
      int huecos=tablero.contarHuecos();
      if (tablero.generarMov(1).size()==0 || tablero.generarMov(2).size()==0){
              if (fichasverdes>fichasrojas){
                  JOptionPane.showMessageDialog(tableroasociado, "¡¡¡Las fichas verdes ganan!!!");
                  jugador1.victoria();
                  jugador1.calcularTipo();
                  jugador2.derrota();
                  jugador2.calcularTipo();
                  jugador1.calcularPuntuacion(fichasverdes,fichasrojas,huecos);
                  jugador2.calcularPuntuacion(fichasrojas,fichasverdes,huecos);
                  tableroasociado.devolverColectorjugador().almacenarJugadores();
              }//Fin del caso en el que haya más fichas verdes que rojas
              else if (tablero.contarFichasR()>tablero.contarFichasV()){
                  JOptionPane.showMessageDialog(tableroasociado, "¡¡¡Las fichas rojas ganan!!!");
                  jugador2.victoria();
                  jugador2.calcularTipo();
                  jugador1.derrota();
                  jugador1.calcularTipo();
                  jugador1.calcularPuntuacion(fichasverdes,fichasrojas,huecos);
                  jugador2.calcularPuntuacion(fichasrojas,fichasverdes,huecos);
                  tableroasociado.devolverColectorjugador().almacenarJugadores();
              }//Fin del caso en el que haya más fichas rojas que verdes
                tableroasociado.getContentPane().removeAll();
                tableroasociado.getContentPane().add(tableroasociado.devolverMenup());
                tableroasociado.pack();
                tableroasociado.devolverMenup().updateUI();
          }//Fin del caso en el que se acaba la partida
  }//Fin del método comprobar
  
  /**
   * <p>Método que decide cuál es el mejor movimiento posible para la máquina</p>
   * @param profact int - Profundidad actual de las jugadas de la máquina
   * @param t TableroLogico - tablero que se introduce al minimax
   * @param max boolean - True si juega max, False si juega min
   * @return int Valor que es mayor según mejor es el movimiento para min
   */
  public int minimax(int profact,TableroLogico t, boolean max){
      int a=0;
      if(max){
          a=2;
      }//Se asocia el valor de fichas rojas para max
      else{
          a=1;
      }//Se asocia el valor de fichas verdes para min
      int puntuacion=0;
      int [][] arr=new int[7][7];
      TableroLogico tl=new TableroLogico(arr);
      tl.modificarNick(t.devolverNick());
      if(profact==3){
          puntuacion=t.evaluate(max);
      }//Fin del caso base
      else{
          ArrayList<TableroLogico> mov=t.generarMov(a);
          if(mov.size()==0){
              puntuacion=t.evaluate(max);
          }//Fin del caso en el que no hay movimientos posibles
          else{
              for(int i=0;i<mov.size();i++){
                  int v=minimax(profact+1,mov.get(i),!max);
                  if(v>puntuacion){
                      puntuacion=v;
                      tl=mov.get(i);
                  }//Fin del caso en el que se obtiene una puntuación mayor a la guardada
              }//Fin del bucle for que gestiona los movimientos generados
          }//Fin del caso en el que sí hay movimientos posibles
      }//Fin del caso inductivo;
      tablero=tl;
      return puntuacion;
  }//Fin del método minimax
    
}//Fin de la clase PanelTablero
