//Se importa lo necesario
import java.io.Serializable;

/**
 * <p>Clase que representa un jugador de Minimax, con su nick, password y datos personales. Implementa la interfaz Serializable</p>
 */
public class Jugador implements Serializable{

    private String nick;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private int nvictorias;
    private int nderrotas;
    private String tipo;
    private int puntuacion;
    
    
    /**
     * <p>Constructor sin argumentos de Jugador</p>
     */
    public Jugador()
    {
        nick="";
        password="";
        nombre="";
        apellidos="";
        dni="";
        email="";
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del constructor sin argumentos
    
    /**
     * <p>Constructor que recibe argumentos de Jugador</p>
     * @param k String - Nick
     * @param p String - Password
     * @param n String - Nombre
     * @param a String - Apellidos
     * @param d String - DNI
     * @param e String - e-mail
     */
    public Jugador(String k,String p,String n,String a,String d,String e)
    {
        nick=k;
        password=p;
        nombre=n;
        apellidos=a;
        dni=d;
        email=e;
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del constructor con argumentos
    
    /**
     * <p>M�todo que cambia el nombre de un jugador</p>
     * @param nombre String - Nombre nuevo del jugador
     */
    public void cambiarNombre(String nombre)
    {
        this.nombre=nombre;
    }//Fin del m�todo cambiarNombre
    
    /**
     * <p>M�todo que cambia los apellidos de un jugador</p>
     * @param apellidos String - Apellidos nuevos del jugador
     */
    public void cambiarApellidos(String apellidos)
    {
        this.apellidos=apellidos;      
    }//Fin del m�todo cambiarApellidos
    
    /**
     * <p>M�todo que cambia el DNI de un jugador</p>
     * @param dni String - DNI nuevo del jugador
     */
    public void cambiarDni(String dni)
    {
        this.dni=dni;
    }//Fin del m�todo cambiarDni
    
    /**
     * <p>M�todo que cambia el e-amil de un jugador</p>
     * @param email String - e-mail nuevo del jugador
     */
    public void cambiarEmail(String email)
    {
        this.email=email;
    }//Fin del m�todo cambiarEmail
    
    /**
     * <p>M�todo que cambia el n�mero de victorias de un jugador</p>
     * @param nvictorias int - N�mero de victorias nuevas
     */
    public void cambiarNvictorias(int nvictorias)
    {
        this.nvictorias=nvictorias;
    }//Fin del m�todo cambiarNvictorias
    
    /**
     * <p>M�todo que cambia el n�mero de derrotas de un jugador</p>
     * @param nderrotas int - N�mero de derrotas nuevas
     */
    public void cambiarNderrotas(int nderrotas)
    {
        this.nderrotas=nderrotas;
    }//Fin del m�todo cambiarNderrotas
    
    /**
     * <p>M�todo que cambia el tipo de un jugador</p>
     * @param tipo String - Tipo de jugador nuevo
     */
    public void cambiarTipo(String tipo)
    {
        this.tipo=tipo;
    }//Fin del m�todo cambiarTipo
    
    /**
     * <p>M�todo que cambia la puntuaci�n del jugador</p>
     * @param puntuacion int - Puntuaci�n nueva
     */
    public void cambiarPuntuacion(int puntuacion)
    {
        this.puntuacion=puntuacion;
    }//Fin del m�todo cambiarPuntuacion
    
    /**
     * <p>M�todo que devuelve el nick del jugador</p>
     * @return String Nick
     */
    public String devolverNick(){
        return nick;
    }//Fin del m�todo devolverNick
    
    /**
     * <p>M�todo que devuelve la password del jugador</p>
     * @return String password
     */
    public String devolverPassword(){
        return password;
    }//Fin del m�todo devolverPassword
    
    /**
     * <p>M�todo que devuelve el nombre del jugador</p>
     * @return String nombre
     */
    public String devolverNombre()
    {
        return nombre;
    }//Fin del m�todo devolverNombre
    
    /**
     * <p>M�todo que devuelve los apellidos del jugador</p>
     * @return String apellidos
     */
    public String devolverApellidos()
    {
        return apellidos;
    }//Fin del m�todo devolverApellidos
    
    /**
     * <p>M�todo que devuelve el DNI del jugador</p>
     * @return String DNI
     */
    public String devolverDni()
    {
        return dni;
    }//Fin del m�todo devolverDni
    
    /**
     * <p>M�todo que devuelve el e-mail del jugador</p>
     * @return String e-mail
     */
    public String devolverEmail()
    {
        return email;
    }//Fin del m�todo devolverEmail
    
    /**
     * <p>M�todo que devuelve el n�mero de victorias del jugador</p>
     * @return int N� victorias
     */
    public int devolverNvictorias()
    {
        return nvictorias;
    }//Fin del m�todo devolverNvictorias
    
    /**
     * <p>M�todo que devuelve el n�mero de derrotas del jugador</p>
     * @return int N� derrotas
     */
    public int devolverNderrotas()
    {
        return nderrotas;
    }//Fin del m�todo devolverNderrotas
    
    /**
     * <p>M�todo que devuelve el tipo de jugador</p>
     * @return String Tipo del jugador
     */
    public String devolverTipo()
    {
        return tipo;
    }//Fin del m�todo devolverTipo
    
    /**
     * <p>M�todo que devuelve la puntuaci�n del jugador</p>
     * @return int Puntuaci�n del jugador
     */
    public int devolverPuntuacion()
    {
        return puntuacion;
    }//Fin del m�todo devolverPuntuacion
    
    /**
     * <p>M�todo que calcula la Puntuaci�n de un jugador y la modifica</p>
     * @param a int - N� fichas del jugador
     * @param b int - N� fichas del rival
     * @param h int - N� huecos
     */
    public void calcularPuntuacion(int a,int b,int h){
        if(a==0){
            puntuacion=puntuacion-600;
        }//Fin del caso de 0 fichas del jugador
        if(a<=b){
          puntuacion=puntuacion+((a-b)*10);  
        }//Fin del caso del jugador con menos fichas que el rival
        if(b==0){
            puntuacion=puntuacion+600;
        }//Fin del caso de 0 fichas del rival
        if(a>=b){
            puntuacion=puntuacion+((a-b)*10);
        }//Fin del caso del jugador con m�s fichas que el rival
    }//Fin del m�todo calcularPuntuacion
    
    /**
     * <p>M�todo que asocia un tipo de jugador seg�n su puntuaci�n</p>
     */
    String calcularTipo()
    {
        if(nvictorias>nderrotas){
            if(puntuacion<0){
                tipo="Esclavo";}
                else{
                if(puntuacion<=3000){
                    tipo="Campesino";
                }
                else if(puntuacion>3000 && puntuacion<=7000){
                        tipo="Mozo de cuadras";
                    }
                    else{
                        if(puntuacion>7000 && puntuacion<=15000){
                            tipo="Caballero";}
                        else{
                            tipo="Se�or Feudal";
                        }
                    }
                }
            }//Fin del caso de m�s victorias que derrotas
        else{
            if(puntuacion>0){
                tipo="Campesino";
            }
            else{
                if(puntuacion>=-2000){
                    tipo="Esclavo";
                }
                else{
                    if(puntuacion>=-6000){
                        tipo="Preso";
                    }
                    else{
                        tipo="Est�s destinado a morir en la horca";
                    }
                    }
                }
            }//Fin del caso de m�s derrotas que victorias
        return tipo;
        }//Fin del m�todo calcularTipo
    
    /**
     * <p>M�todo que reinicia las estad�sticas a 0</p>
     */
    public void reiniciarEstadistica()
    {
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del m�todo reiniciarEstadistica
    
    /**
     * <p>M�todo que a�ade una victoria al jugador</p>
     */
    public void victoria(){
       nvictorias++;
    }//Fin del m�todo victoria
    
    /**
     * <p>M�todo que a�ade una derrota al jugador</p>
     */
     public void derrota(){
        nderrotas++;
     }//Fin del m�todo derrota
}//Fin de la clase Jugador