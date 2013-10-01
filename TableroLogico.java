//Se importa lo necesario
import java.util.*;
import java.io.*;

/**
 * <p>Clase que representa de forma numérica un tablero de Attax. Implementa la interfaz Serializable</p>
 * @author Jose y Alberto
 */
public class TableroLogico implements Serializable{
  public static final int VACIO=0;
    public static final int VERDE=1;
    public static final int ROJA=2;
    public static final int profmax=1;
    private int turno=1;
    private String nick;
    /**
     * <p>Array bidimensional de enteros que representa el tablero</p>
     */
    public int[][] tablafichas;
    
    /**
     * <p>Constructor sin argumentos de TableroLogico</p>
     */
    public TableroLogico(){
        tablafichas=new int[7][7];
        tablafichas[0][0]=2;
        tablafichas[6][6]=2;
        tablafichas[0][6]=1;
        tablafichas[6][0]=1;
        nick="";
    }//Fin del constructor sin argumentos
    
    /**
     * <p>Constructor que recibe un argumento de TableroLogico</p>
     * @param arr int[][] - Array bidimensional del tablero
     */
    public TableroLogico(int [][] arr){
        tablafichas=arr;
    }//Fin del constructor con argumento
    
    //MÉTODOS
    
    /**
     * <p>Método que devuelve el turno de la partida</p>
     * @return int Turno de la partida
     */
    public int devolverTurno(){
        return turno;
    }//Fin del método devolverTurno
    
    /**
     * <p>Método que modifica el turno</p>
     * @param turno int - Turno nuevo
     */
    public void modificarTurno(int turno){
        this.turno=turno;
    }//Fin del método modificarTurno
    
    /**
     * <p>Método que devuelve el nick asociado al tablero</p>
     * @return String Nick asociado
     */
    public String devolverNick(){
        return nick;
    }//Fin del método devolverNick
    
    /**
     * <p>Método que modifica el nick asociado</p>
     * @param nick String - Nick nuevo
     */
    public void modificarNick(String nick){
        this.nick=nick;
    }//Fin del método modificarNick
    
    /**
     * <p>Método que muestra por pantalla un tablero (por alguna razón para la salida por pantalla se invierten filas y columnas)</p>
     */
    public void imprimir(){
        for (int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(devolverPos(j,i)+" ");
            }//Fin del bucle for de las filas
            System.out.println();
        }//Fin del bucle for de las columnas
    }//Fin del método imprimir
    
    /**
     * <p>Método que copia un tablero</p>
     * @param tab2 TableroLogico - Tablero en el que se copia el tablero seleccionado
     */
    public void copiarTab(TableroLogico tab2){
        for (int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                tab2.modificarPos(i,j,this.devolverPos(i,j));
            }//Fin del bucle for de las columnas
        }//Fin del bucle for de las filas
    }//Fin del método copiarTab
    
    /**
     * <p>Método que devuelve un valor del tablero según su posición</p>
     * @param f int - Fila elegida
     * @param c int - Columna elegida
     * @return int Valor del tablero en la posición
     */
    public int devolverPos(int f,int c){
        return tablafichas[f][c];
    }//Fin del método devolverPos
    
    /**
     * <p>Método que modifica una posición del tablero</p>
     * @param f int - Fila elegida
     * @param c int - Columna elegida
     * @param v int - Valor nuevo para la posición
     */
    public void modificarPos(int f,int c,int v){
        if (v==0||v==1||v==2){
            tablafichas[f][c]=v;
        }//Fin de la condición de los valores permitidos
    }//Fin del método modificarPos
    
    /**
     * <p>Método que cuenta el número de fichas verdes</p>
     * @return int Nº de fichas verdes
     */
    public int contarFichasV(){
        int fichasV=0;
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (devolverPos(i,j)==1){
                    fichasV++;
                }//Fin de la condición de que la ficha sea verde
            }//Fin del bucle for de las columnas
        }//Fin del bucle for de las filas
        return fichasV;
    }//Fin del método contarFichasV
    
    /**
     * <p>Método que cuenta el número de fichas rojas</p>
     * @return int Nº de fichas rojas
     */
    public int contarFichasR(){
        int fichasR=0;
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (devolverPos(i,j)==2){
                    fichasR++;
                }//Fin de la condición de que la ficha sea roja
            }//Fin del bucle for de las columnas
        }//Fin del bucle for de las filas
        return fichasR;
    }//Fin del método contarFichasR
    
    /**
     * <p>Método que cuenta el número de huecos</p>
     * @return int Nº de huecos
     */
    public int contarHuecos(){
        int huecos=0;
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                if (devolverPos(i,j)==0){
                    huecos++;
                }//Fin de la condición de que haya un hueco
            }//Fin del bucle for de las columnas
        }//Fin del bucle for de las filas
        return huecos;
    }//Fin del método contarHuecos
    
    /**
     * <p>Función de evaluación para un tablero</p>
     * @param max boolean - True si juega el jugador MAX, False si juega el jugador MIN (para Minimax)
     * @return int Valor de la función para el tablero
     */
  public int evaluate(boolean max){
      if (max)
          return contarFichasV()-contarFichasR();
      else
          return contarFichasR()-contarFichasV();
  }//Fin del método evaluate
  
  /**
   * <p>Método que mueve una ficha (movimiento radio 2)</p>
   * @param xi int - Posición horizontal inicial
   * @param yi int - Posición vertical inicial
   * @param xf int - Posición horizontal final
   * @param yf int - Posición vertical final
   * @return boolean - True si se produce movimiento, False si no
   */
  public boolean mover(int xi,int yi,int xf,int yf){
        if(devolverPos(xf,yf)==0){
            modificarPos(xf,yf,devolverPos(xi,yi));
            modificarPos(xi,yi,0);
            comer(xf,yf);
            return true;
        }//Fin de la condición de que se mueva a un hueco
        else{
            return false;
        }//Fin del caso contrario
  }//Fin del método mover
  
  /**
   * <p>Método que duplica una ficha (movimiento radio 1)</p>
   * @param xi int - Posición horizontal inicial
   * @param yi int - Posición vertical inicial
   * @param xf int - Posición horizontal final
   * @param yf int - Posición vertical final
   * @return boolean - True si se produce movimiento, False si no
   */
  public boolean duplicar(int xi,int yi,int xf,int yf){
      if(devolverPos(xi,yi)!=0){
          if(devolverPos(xf,yf)==0){
            modificarPos(xf,yf,devolverPos(xi,yi));
            comer(xf,yf);
            return true;
          }//Fin del caso en el que se mueve a un hueco
          else{
              return false;
          }//Fin del caso en el que no se mueve a un hueco
      }//Fin del caso en el que no seleccionamos un hueco
      else{
          return false;
      }//Fin del caso contrario
  }//Fin del método duplicar
  
  /**
   * <p>Método que da la vuelta a las fichas de color contrario que rodean a una ficha</p>
   * @param x int - Posición horizontal de la ficha
   * @param y int - Posición vertical de la ficha
   */
  public void comer(int x,int y){
      int color=devolverPos(x,y);
      for(int i=x+1;i>=x-1;i--){
          for(int j=y-1;j<=y+1;j++){
              if (i>=0 && i<=6 && j>=0 && j<=6){
                if (devolverPos(i,j)!=0){
                      modificarPos(i,j,color);
                }//Fin de la condición de que no haya un hueco
              }//Fin de la condición de que esté dentro de los límites del tablero
          }//Fin del bucle for de las columnas
      }//Fin del bucle for de las filas
  }//Fin del método comer
  
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
   * <p>Método que almacena en un ArrayList todos los posibles movimientos dado un turno</p>
   * @param a int - Turno del jugador del que se calculan movimientos
   * @return ArrayList<TableroLogico> Contenedor de movimientos posibles
   */
  public ArrayList<TableroLogico> generarMov(int a){
      ArrayList<TableroLogico> mov=new ArrayList<TableroLogico>();
      if (a==1 || a==2){
      for (int i=0;i<7;i++){
          for(int j=0;j<7;j++){
              if(this.devolverPos(i,j)==a){
                  for (int h=i-2;h<=i+2;h++){
                      if(h>=0 && h<7){
                      for (int k=j-2;k<=j+2;k++){
                          if (k>=0 && k<7){
                              if(this.devolverPos(h,k)==0){
                              if(h!=i || k!=j){
                              int [][] array=new int[7][7];
                              TableroLogico tab=new TableroLogico();
                              tab.modificarNick(this.devolverNick());
                              this.copiarTab(tab);
                              if(maximo(Math.abs(h-i),Math.abs(k-j))==1){
                                  tab.duplicar(i,j,h,k);
                                  tab.comer(h,k);
                              }//Fin de la condición de movimiento radio 1
                              else if(maximo(Math.abs(h-i),Math.abs(k-j))==2){
                                  tab.mover(i,j,h,k);
                                  tab.comer(h,k);
                              }//Fin de la condición de movimiento radio 2
                              mov.add(tab);
                          }//Fin de la condición de que no esté en la misma posición
                          }//Fin de la condición de que la posición final sea hueco
                          }//Fin de la comprobación de que no se sale de los límites verticales del tablero
                          }//Fin del bucle de las posiciones verticales posibles de una ficha
                      }//Fin de la comprobación de que no se sale de los límites horizontales del tablero
                  }//fin del bucle de posiciones horizontales posibles de una ficha
              }//Fin de la comprobación de que la ficha corresponde al turno
          }//Fin del bucle de posiciones iniciales verticales
      }//Fin del bucle de posiciones iniciales horizontales
  }//Fin de la condición de turno 1 ó 2
      else{
          System.out.println("El turno debe ser 1 ó 2.");
      }//Fin de la condición de turno no válido
      return mov;
  }//Fin del método generarMov
  
}//Fin de la clase TableroLogico