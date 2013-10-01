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
    
    //M�TODOS
    
    /**
     * <p>M�todo que devuelve un tablero</p>
     * @return TableroLogico asociado al jPanel
     */
    public TableroLogico devolverTablero(){
        return tablero;
    }//Fin del m�todo devolverTablero
    
    /**
     * <p>M�todo que modifica un tablero</p>
     * @param tablero TableroLogico nuevo
     */
    public void modificarTablero(TableroLogico tablero){
        this.tablero=tablero;
    }//Fin del m�todo modificarTablero
    
    /**
     * <p>M�todo que devuelve el jugador 1</p>
     * @return Jugador 1
     */
    public Jugador devolverJugador1(){
        return jugador1;
    }//Fin del m�todo devolverJugador1
    
    /**
     * <p>M�todo que devuelve el jugador 2</p>
     * @return Jugador 2
     */
    public Jugador devolverJugador2(){
        return jugador2;
    }//Fin del m�todo devolverJugador2

/**
 * <p>Metodo para agregar un circulo mediante la fila y la columna</p>
 * @param fila int - Fila que ocupa el c�rculo
 * @param columna int - Columna que ocupa el c�rculo
 */
public void agregarCirculo(int fila, int columna){
    Ellipse2D.Float circulo;
    int xSupIzq=columna*dimensionCasilla+5;
    int ySupIzq=fila*dimensionCasilla+5;
    circulo=new Ellipse2D.Float(xSupIzq,ySupIzq,dimensionCasilla-10,dimensionCasilla-10);
    circulos[fila][columna]=circulo;
}//Fin del m�todo agregarCirculo

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
 }//Fin del m�todo paint
 
  /**
   * <p>M�todo que crea las l�neas delimitadoras</p>
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
  }//Fin del m�todo crearLineasDelimitadoras
  
  /**
   * <p>M�todo que comprueba si se est� jugando en modo multijugador</p>
   * @return boolean True si es multijugador, False si es un jugador
   */
  public boolean devolverMulti(){
        return multijugador;
    }//Fin del m�todo devolverMulti
    
  /**
   * <p>M�todo que modifica el modo de juego (multijugador o no)</p>
   * @param multijugador boolean
   */
    public void modificarMulti(boolean multijugador){
        this.multijugador=multijugador;
    }//Fin del m�todo modificarMulti
  
  /**
   * <p>M�todo que hace la llamada al m�todo mover de TableroLogico en el panel</p>
   * @param xi int - Posici�n horizontal inicial
   * @param yi int - Posici�n vertical inicial
   * @param xf int - Posici�n horizontal final
   * @param yf int - Posici�n vertical final
   */
  public boolean moverG(int xi,int yi,int xf,int yf){
      tablero.mover(xi,yi,xf,yf);
      comprobar();
      repaint();
      return tablero.duplicar(xi,yi,xf,yf);
  }//Fin del m�todo moverG

  
  /**
   * <p>M�todo que hace la llamada al m�todo duplicar de TableroLogico en el panel</p>
   * @param xi int - Posici�n horizontal inicial
   * @param yi int - Posici�n vertical inicial
   * @param xf int - Posici�n horizontal final
   * @param yf int - Posici�n vertical final
   */
  public boolean duplicarG(int xi,int yi,int xf,int yf){
      tablero.duplicar(xi,yi,xf,yf);
      comprobar();
      repaint();
      return tablero.duplicar(xi,yi,xf,yf);
   }//Fin del m�todo duplicarG
  
  /**
   * <p>M�todo que haya el m�ximo entre dos n�meros</p>
   * @param x int - Un n�mero
   * @param y int - Otro n�mero
   * @return int El m�ximo de ambos n�meros
   */
  public int maximo(int x,int y){
    if (x>y){
      return x;
    }//Fin de la condici�n x>y
    else{
      return y;
    }//Fin de la condici�n y>x
  }//Fin del m�todo maximo
  
  /**
   * <p>M�todo que elige el movimiento posible seg�n la posici�n de origen y destino de la ficha. Distingue entre un jugador y multijugador</p>
   * @param xi int - Posici�n horizontal inicial
   * @param yi int - Posici�n vertical inicial
   * @param xf int - Posici�n horizontal final
   * @param yf int - Posici�n vertical final
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
                         }//Fin de la condici�n de las fichas verdes
                         else if(tablero.devolverTurno()==2){
                             tablero.modificarTurno(1);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador1.devolverNick());
                         }//FIn de la condici�n de las fichas rojas
                    }//Fin del caso para movimiento de radio 1
                    else if(maximo(Math.abs(xf-xi),Math.abs(yf-yi))==2){
                       moverG(xi,yi,xf,yf);
                       if(tablero.devolverTurno()==1){
                             tablero.modificarTurno(2);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador2.devolverNick());
                         }//Fin de la condici�n de las fichas verdes
                       else if(tablero.devolverTurno()==2){
                             tablero.modificarTurno(1);
                             JOptionPane.showMessageDialog(tableroasociado, "Turno de "+jugador1.devolverNick());
                         }//Fin de la condici�n de las fichas rojas
                     }//Fin del caso para movimiento de radio 2
                }//Fin de la comprobaci�n de que la posici�n final sea un hueco
            }//Fin de la comprobaci�n de que no movamos un hueco
        }//Fin de la comprobaci�n de que estemos en el turno correcto
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
                }//Fin de la comprobaci�n de que la posici�n final sea un hueco
            }//Fin de la condici�n de que no movamos huecos
        }//Fin de la condici�n de las fichas verdes
      }//Fin del modo de un jugador
  }//Fin del m�todo movimiento

  
  /**
   * <p>M�todo que comprueba cada turno la situaci�n de la partida y cu�ndo hay un ganador</p>
   */
  public void comprobar(){
      int fichasverdes=tablero.contarFichasV();
      int fichasrojas=tablero.contarFichasR();
      int huecos=tablero.contarHuecos();
      if (tablero.generarMov(1).size()==0 || tablero.generarMov(2).size()==0){
              if (fichasverdes>fichasrojas){
                  JOptionPane.showMessageDialog(tableroasociado, "���Las fichas verdes ganan!!!");
                  jugador1.victoria();
                  jugador1.calcularTipo();
                  jugador2.derrota();
                  jugador2.calcularTipo();
                  jugador1.calcularPuntuacion(fichasverdes,fichasrojas,huecos);
                  jugador2.calcularPuntuacion(fichasrojas,fichasverdes,huecos);
                  tableroasociado.devolverColectorjugador().almacenarJugadores();
              }//Fin del caso en el que haya m�s fichas verdes que rojas
              else if (tablero.contarFichasR()>tablero.contarFichasV()){
                  JOptionPane.showMessageDialog(tableroasociado, "���Las fichas rojas ganan!!!");
                  jugador2.victoria();
                  jugador2.calcularTipo();
                  jugador1.derrota();
                  jugador1.calcularTipo();
                  jugador1.calcularPuntuacion(fichasverdes,fichasrojas,huecos);
                  jugador2.calcularPuntuacion(fichasrojas,fichasverdes,huecos);
                  tableroasociado.devolverColectorjugador().almacenarJugadores();
              }//Fin del caso en el que haya m�s fichas rojas que verdes
                tableroasociado.getContentPane().removeAll();
                tableroasociado.getContentPane().add(tableroasociado.devolverMenup());
                tableroasociado.pack();
                tableroasociado.devolverMenup().updateUI();
          }//Fin del caso en el que se acaba la partida
  }//Fin del m�todo comprobar
  
  /**
   * <p>M�todo que decide cu�l es el mejor movimiento posible para la m�quina</p>
   * @param profact int - Profundidad actual de las jugadas de la m�quina
   * @param t TableroLogico - tablero que se introduce al minimax
   * @param max boolean - True si juega max, False si juega min
   * @return int Valor que es mayor seg�n mejor es el movimiento para min
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
                  }//Fin del caso en el que se obtiene una puntuaci�n mayor a la guardada
              }//Fin del bucle for que gestiona los movimientos generados
          }//Fin del caso en el que s� hay movimientos posibles
      }//Fin del caso inductivo;
      tablero=tl;
      return puntuacion;
  }//Fin del m�todo minimax
    
}//Fin de la clase PanelTablero
